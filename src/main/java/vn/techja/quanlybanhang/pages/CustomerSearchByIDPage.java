
package vn.techja.quanlybanhang.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Customer;
import vn.techja.quanlybanhang.service.CustomerService;
import vn.techja.quanlybanhang.service.CustomerServiceImpl;
import vn.techja.quanlybanhang.ui.TableUI;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;


public class CustomerSearchByIDPage extends Page {

    @Override
    public void displayContent() {
        try {
            CustomerService customerService = new CustomerServiceImpl();
            
            int check = AppScanner.scanIntWithMessage(I18n.getEntityMessage("customer", "entity.scan.id.detail"));
            while (customerService.findById(check) == null) {
                I18n.printEntityMessage("customer", "entity.error.idNotFound");
                AppScanner.scanIntWithMessage(I18n.getEntityMessage("customer", "entity.scan.id.detail"));
            }
            List<Customer> customers = new ArrayList<>();
            customers.add(customerService.findById(check));
            if (customers.isEmpty()) {
                System.out.println("Trong !");
            } else {
                List<Object[]> rows = new ArrayList<>();
                for (Customer c : customers) {
                    Object[] row = {
                        c.getId(),
                        c.getName(),
                        c.getAddress(),
                        c.getPhone(),
                        c.getEmployee().getId(),
                        c.getEmployee().getName(),
                        c.getDiscount(),
                        c.getSalePoint()
                    };
                    rows.add(row);
                }
                String[] headers = {"ID", "Name", "Address", "Phone", "Employee ID", "Employee Name", "Discount", "Sale Point"};
                TableUI theTable = new TableUI(headers, rows);
                theTable.display();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerSearchByIDPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getTitle() {
        return I18n.getMessage("customer.title.searchByID");
    }

}
