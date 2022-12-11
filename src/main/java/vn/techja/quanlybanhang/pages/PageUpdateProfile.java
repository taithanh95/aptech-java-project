
package vn.techja.quanlybanhang.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Employee;
import vn.techja.quanlybanhang.service.AuthServiceImpl;
import vn.techja.quanlybanhang.service.EmployeeService;
import vn.techja.quanlybanhang.service.EmployeeServiceImpl;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;


public class PageUpdateProfile extends Page {
    
    private final EmployeeService empService;

    public PageUpdateProfile() {
        this.empService = new EmployeeServiceImpl();
    }
    
    @Override
    public void displayContent() {
        try {
            Employee emp = AuthServiceImpl.getCurrentEmployee();
            System.out.println("ID: " + emp.getId());
            System.out.println(I18n.getMessage("employee.username") + ": " + emp.getUsername());
            System.out.println(I18n.getMessage("employee.dept") + ": " + emp.getDepartment());
            
            String name = AppScanner.scanStringWithMessage(I18n.getMessage("employee.name"));
            String address = AppScanner.scanStringWithMessage(I18n.getMessage("employee.addr"));
            String phone = AppScanner.scanStringWithMessage(I18n.getMessage("employee.phone"));
            emp.setName(name);
            emp.setAddress(address);
            emp.setPhone(phone);
            if (empService.update(emp)) {
                I18n.printEntityMessage("employee", "entity.msg.updated");
            } else {
                I18n.printEntityMessage("employee", "entity.error.updateFailed");
            }
        } catch (Exception ex) {
            Logger.getLogger(PageUpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getMessage("title.updateProfile");
    }
    
}
