
package vn.techja.quanlybanhang.pages;

import vn.techja.quanlybanhang.common.StringCommon;
import vn.techja.quanlybanhang.entities.Department;
import vn.techja.quanlybanhang.entities.Employee;
import vn.techja.quanlybanhang.service.EmployeeService;
import vn.techja.quanlybanhang.service.EmployeeServiceImpl;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;
import vn.techja.quanlybanhang.utilities.Md5;


public class EmployeeCreatePage extends Page {

    private final EmployeeService employeeService;

    public EmployeeCreatePage() {
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public void displayContent() {
        try {
            String name = AppScanner.scanStringWithi18Message("employee.scan.name");
            String address = AppScanner.scanStringWithi18Message("employee.scan.addr");
            String phone = AppScanner.scanStringWithi18Message("employee.scan.phone");

            int department = 0;
            do {
                department = AppScanner.scanIntWithMessage(
                        I18n.getMessage("employee.scan.dept")
                        + String.format("(1=%s; 2=%s; 3=%s)", 
                                StringCommon.getDepartmentString(Department.ROLE_ADMIN),
                                StringCommon.getDepartmentString(Department.ROLE_EMPLOYEE_CASHER), 
                                StringCommon.getDepartmentString(Department.ROLE_EMPLOYEE_INVENTORY))
                );

                if (department < 1 || department > 3) {
                    I18n.print("employee.error.invalidDept");
                }
            } while (department < 1 || department > 3);

            String username;
            do {
                username = AppScanner.scanStringWithi18Message("employee.scan.username");
                if (username.length() < 6) {
                    I18n.print("employee.error.invalidUsernameLength");
                }
            } while (username.length() < 6);

            String password;
            do {
                password = AppScanner.scanStringWithi18Message("employee.scan.password");

                if (username.length() < 6) {
                    I18n.print("employee.error.invalidPassLength");
                }
            } while (username.length() < 6);

            Employee employee = new Employee(name, address, phone, Department.fromInt(department), username, Md5.encode(password));
            if (employeeService.create(employee)) {
                I18n.printEntityMessage("employee", "entity.msg.created");
            } else {
                I18n.printEntityMessage("employee", "entity.error.createFailed");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("employee", "entity.title.create");
    }

}
