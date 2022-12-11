
package vn.techja.quanlybanhang.pages;

import java.util.ArrayList;
import java.util.List;

import vn.techja.quanlybanhang.common.StringCommon;
import vn.techja.quanlybanhang.entities.Product;
import vn.techja.quanlybanhang.service.ProductService;
import vn.techja.quanlybanhang.service.ProductServiceImpl;
import vn.techja.quanlybanhang.ui.TableUI;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;

public class ProductDetailPage extends Page {

    @Override
    public void displayContent() {
        ProductService productService = new ProductServiceImpl();
        String choice = null;
        while(true) {          
            try {
                int productId = AppScanner.scanIntWithMessage(I18n.getEntityMessage("product", "entity.scan.id.detail"));
                Product product = productService.findById(productId);
                if (product == null) {
                    I18n.printEntityMessage("product", "entity.error.idNotFound");
                } else {
                    List<Object[]> rows = new ArrayList<>();
                    Object[] row = {
                        product.getId(),
                        StringCommon.safeNullObject(product.getBrand().getName()),
                        StringCommon.safeNullObject(product.getCategory().getName()),
                        StringCommon.safeNullObject(product.getSupplier().getName()),
                        StringCommon.safeNullObject(product.getEmployee().getName()),
                        product.getName(),
                        product.getPriceString(),
                        StringCommon.formatNumberCommas(product.getQuantityInStock()),
                        product.getCreatedAtString(),
                        product.getUpdatedAtString()
                    };
                    rows.add(row);
                    
                    String[] headers = {
                        "ID",
                        I18n.getMessage("brand.label.singular"),
                        I18n.getMessage("category.label.singular"),
                        I18n.getMessage("supplier.label.singular"),
                        I18n.getMessage("employee.label.singular"),
                        I18n.getMessage("product.label.singular"),
                        I18n.getMessage("product.price"),
                        I18n.getMessage("product.qty"),
                        I18n.getMessage("entity.createdAt"),
                        I18n.getMessage("entity.updatedAt")
                    };
                    TableUI tableUI = new TableUI(headers,rows);
                    tableUI.display();
            
                    choice = AppScanner.scanStringWithMessage(I18n.getEntityMessage("product", "entity.confirm.findMore"));
                    
                    if (!"y".equalsIgnoreCase(choice)) {
                        break;
                    }
                    
                    System.out.println(""); //space line
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("product", "entity.title.detail");
    }
    
}