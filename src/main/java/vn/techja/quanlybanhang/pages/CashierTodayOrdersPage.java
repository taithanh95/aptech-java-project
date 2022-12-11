
package vn.techja.quanlybanhang.pages;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.common.StringCommon;
import vn.techja.quanlybanhang.entities.Order;
import vn.techja.quanlybanhang.service.OrderService;
import vn.techja.quanlybanhang.service.OrderServiceImpl;
import vn.techja.quanlybanhang.ui.TableUI;
import vn.techja.quanlybanhang.utilities.I18n;
import vn.techja.quanlybanhang.utilities.PaginatedResults;


public class CashierTodayOrdersPage extends Page {
    
    private final OrderService orderService;
    
    public CashierTodayOrdersPage() {
        this.orderService = new OrderServiceImpl();
    }
    
    @Override
    public void displayContent() {
        try {
            int page = 1;
            do {
                PaginatedResults<Order> results = orderService.todayOrder(page);
                if (results.getResults().isEmpty()) {
                    I18n.printEntityMessage("order", "entity.msg.emptyResults");
                    return;
                }
                List<Object[]> rows = new ArrayList<>();
                
                for (Order order : results.getResults()) {
                    Object[] row = {
                        order.getId(),
                        order.getEmployee().getName(),
                        StringCommon.safeNullObject(order.getCustomer().getName()),
                        order.getDatetimeString(),
                        order.getAmountString()
                    };
                    rows.add(row);
                }
                String[] headers = {
                    "ID",
                    I18n.getMessage("order.emp"),
                    I18n.getMessage("order.customer"),
                    I18n.getMessage("entity.createdAt"),
                    I18n.getMessage("order.total")
                };
                TableUI tableUI = new TableUI(headers, rows);
                tableUI.display();
                
                if (results.needsPagination()) {
                    results.displayPagination();
                    results.displayPaginationMenu();
                    page = results.scanGoPage();
                    System.out.println("");
                } else {
                    page = 0;
                }
                
            } while (page > 0);
        } catch (SQLException e) {
            System.out.println("Exception when ProductMenu.handleSearch: " + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(CashierTodayOrdersPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getTitle() {
        return I18n.getMessage("title.cashierTodayOrders");
    }
    
}
