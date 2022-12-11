
package vn.techja.quanlybanhang.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Customer;
import vn.techja.quanlybanhang.entities.Employee;
import vn.techja.quanlybanhang.service.AuthServiceImpl;
import vn.techja.quanlybanhang.service.CustomerService;
import vn.techja.quanlybanhang.service.CustomerServiceImpl;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;


public class CustomerCreatePage extends Page {

    @Override
    public void displayContent() {
        try {
            CustomerService customerService = new CustomerServiceImpl();
            String name = AppScanner.scanStringWithMessage(I18n.getMessage("customer.scan.name"));
            String phone = AppScanner.scanStringWithMessage(I18n.getMessage("customer.scan.phone"));
            String add = AppScanner.scanStringWithMessage(I18n.getMessage("customer.scan.addr"));
            Employee employee = AuthServiceImpl.getCurrentEmployee();
            Customer customer = new Customer(name, phone, add, employee);
            if (customerService.create(customer)) {
                I18n.printEntityMessage("customer", "entity.msg.created");
            } else {
                I18n.printEntityMessage("customer", "entity.msg.createFailed");
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerCreatePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("customer", "entity.title.create");
    }

}
