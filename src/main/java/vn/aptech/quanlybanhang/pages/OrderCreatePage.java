
package vn.aptech.quanlybanhang.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import vn.aptech.quanlybanhang.entities.Customer;
import vn.aptech.quanlybanhang.entities.Order;
import vn.aptech.quanlybanhang.entities.OrderItem;
import vn.aptech.quanlybanhang.entities.Product;
import vn.aptech.quanlybanhang.utilities.AppScanner;
import vn.aptech.quanlybanhang.utilities.I18n;
import vn.aptech.quanlybanhang.common.StringCommon;
import vn.aptech.quanlybanhang.service.AuthServiceImpl;
import vn.aptech.quanlybanhang.service.CustomerService;
import vn.aptech.quanlybanhang.service.CustomerServiceImpl;
import vn.aptech.quanlybanhang.service.OrderService;
import vn.aptech.quanlybanhang.service.OrderServiceImpl;
import vn.aptech.quanlybanhang.service.ProductService;
import vn.aptech.quanlybanhang.service.ProductServiceImpl;
import vn.aptech.quanlybanhang.ui.TableUI;


public class OrderCreatePage extends Page {

    private final ProductService productService;
    private OrderService orderService;
    private final CustomerService customerService;

    public OrderCreatePage() {
        this.productService = new ProductServiceImpl();
        this.orderService = new OrderServiceImpl();
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    public void displayContent() {
        try {
            String choice;
            Order order = new Order();
            double amount = 0;
            while (true) {
                int productId = AppScanner.scanIntWithi18Message("order.scan.product.id");
                OrderItem orderItem = new OrderItem();
                Product product = productService.findById(productId);
                if (product == null) {
                    I18n.print("order.error.product.notFound");
                    continue;
                }
                
                I18n.print("order.msg.product.foundOne", product.getName());
                orderItem.setProduct(product);
                
                int qty = AppScanner.scanIntWithi18Message("order.scan.product.qty");
                if (product.getQuantityInStock() < 1) {
                    I18n.print("order.error.product.outOfStock");
                    continue;
                }
                if (product.getQuantityInStock() < qty) {
                    I18n.print("order.error.product.insufStock", orderItem.getProduct().getQuantityInStock());
                    qty = product.getQuantityInStock(); // L???y s??? l?????ng t???n kho
                }
                
                // Ki???m tra xem SP ???? t???n t???i trong Order hay ch??a
                boolean alreadyExist = false;
                for (OrderItem od : order.getOrderItems()) {
                    if (od.getProduct().getId() == productId) {
                        qty += od.getQuantity();
                        alreadyExist = true;
                        // N???u t???n t???i th?? c??ng th??m s??? l?????ng
                        od.getProduct().setQuantityInStock(qty);
                        od.setQuantity(qty);
                    }
                }
                if (!alreadyExist) {
                    // N???u ch??a t???n t???i th?? th??m m???i SP
                    orderItem.getProduct().setQuantityInStock(qty);
                    orderItem.setQuantity(qty);
                    orderItem.setProductName(product.getName());
                    orderItem.setProductPrice(product.getPrice());
                    orderItem.setDiscountPrice(product.getDiscountPrice());
                    orderItem.setDiscount(product.getDiscount());
                    
                    order.getOrderItems().add(orderItem);
                }
                // Set n???t discount va discount Price
                choice = AppScanner.scanStringWithMessage(I18n.getMessage("order.confirm.addAnotherProduct"), true);

                if (!"y".equalsIgnoreCase(choice)) {
                    break;
                }
            }
            for (OrderItem od : order.getOrderItems()) {
                amount += od.getTotal(); // T??nh t???ng gi?? tr??? ????n h??ng
            }
            order.setAmount(amount);
            order.setEmployee(AuthServiceImpl.getCurrentEmployee()); // Set nh??n vi??n hi???n t???i ??ang ????ng nh???p
            
            // ask for order customer
            Customer customer = null;
            if (AppScanner.confirm(I18n.getMessage("order.confirm.orderHasCustomer"))) {
                
                while (true) {
                    int customerId = AppScanner.scanIntWithMessage(I18n.getMessage("order.scan.customer"));
                    
                    if ((customer = customerService.findById(customerId)) == null) {
                        I18n.print("order.error.invalidCustomer");
                    } else {
                        break;
                    }
                }
                
                // print customer detail
                I18n.print(
                        "entity.msg.foundName", 
                        I18n.getMessage("customer.label.singular"), 
                        String.format("%s (%s: %s)", customer.getName(), I18n.getMessage("customer.phone"), customer.getPhone())
                );
            } else {
                customer = new Customer(-1);
            }
            
            order.setCustomer(customer);

            List<Object[]> rows = new ArrayList<>();

            I18n.print("order.msg.detail");
            for (OrderItem orderItem : order.getOrderItems()) {
                Object[] row = {
                    orderItem.getProduct().getId(),
                    orderItem.getProductName(),
                    orderItem.getProductPriceString(),
                    orderItem.getProductFinalPriceString(),
                    orderItem.getQuantity(),
                    orderItem.getTotalString()
                };

                rows.add(row);
            }

            String[] headers = {
                "ID", 
                I18n.getMessage("product.label.singular"), 
                I18n.getMessage("product.price"),
                I18n.getMessage("product.price.sale"),
                I18n.getMessage("product.qty"),
                I18n.getMessage("order.subtotal")
            };

            TableUI theTable = new TableUI(headers, rows);
            theTable.display();
            
            System.out.println(I18n.getMessage("order.total") + ": " + StringCommon.convertDoubleToVND(order.getAmount()));

            choice = AppScanner.scanStringWithMessage(I18n.getMessage("order.confirm.saveOrder"), true);
            if ("y".equalsIgnoreCase(choice)) {
                if (orderService.create(order)) {
                    I18n.printEntityMessage("order", "entity.msg.created");

                    choice = AppScanner.scanStringWithMessage(I18n.getMessage("order.export.confirm"), true);
                    if ("y".equalsIgnoreCase(choice)) {
                        String reportFile = orderService.requestReportXlsx(order);
                        if (reportFile != null) {
                            I18n.print("order.export.path", reportFile);
                        } else {
                            I18n.print("order.export.error");
                        }
                    }
                } else {
                    I18n.printEntityMessage("order", "entity.error.createFailed");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(OrderCreatePage.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("order", "entity.title.create");
    }

}
