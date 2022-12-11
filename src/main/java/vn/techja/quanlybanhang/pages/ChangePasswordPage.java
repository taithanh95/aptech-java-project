
package vn.techja.quanlybanhang.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Employee;
import vn.techja.quanlybanhang.service.AuthServiceImpl;
import vn.techja.quanlybanhang.service.EmployeeService;
import vn.techja.quanlybanhang.service.EmployeeServiceImpl;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;
import vn.techja.quanlybanhang.utilities.Md5;


public class ChangePasswordPage extends Page {

    private final EmployeeService employeeService;

    public ChangePasswordPage() {
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public void displayContent() {
        try {
            do {
                String password = AppScanner.scanStringWithMessage(I18n.getMessage("page.changePass.scan.currentPass"));
                Employee employee = AuthServiceImpl.getCurrentEmployee();
                if (!employee.getPassword().equals(Md5.encode(password))) {
                    I18n.print("page.changePass.error.wrongPass");
                } else {
                    String newPassword = AppScanner.scanStringWithMessage(I18n.getMessage("page.changePass.scan.newPass"));
                    String confirmPassword = AppScanner.scanStringWithMessage(I18n.getMessage("page.changePass.scan.repeatPass"));

                    if (!newPassword.equals(confirmPassword)) {
                        I18n.print("page.changePass.error.mismatchPass");
                    } else {
                        employee.setPassword(Md5.encode(newPassword));
                        if (employeeService.update(employee)) {
                            I18n.print("page.changePass.msg.success");
                            break;
                        } else {
                            I18n.print("page.changePass.msg.failed");
                        }
                    }
                }
            } while (true);
        } catch (Exception ex) {
            Logger.getLogger(ChangePasswordPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getMessage("page.changePass.title");
    }

}
