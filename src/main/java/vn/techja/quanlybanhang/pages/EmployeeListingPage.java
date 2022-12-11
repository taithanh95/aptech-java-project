
package vn.techja.quanlybanhang.pages;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.common.StringCommon;
import vn.techja.quanlybanhang.entities.Employee;
import vn.techja.quanlybanhang.service.EmployeeService;
import vn.techja.quanlybanhang.service.EmployeeServiceImpl;
import vn.techja.quanlybanhang.ui.TableUI;
import vn.techja.quanlybanhang.utilities.I18n;

public class EmployeeListingPage extends Page {

    private final EmployeeService employeeService;

    public EmployeeListingPage() {
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public void displayContent() {
        try {
            List<Employee> employees = employeeService.findAll();
            List<Object[]> rows = new ArrayList<>();

            // transfer data to table row
            for (Employee employee : employees) {
                Object[] row = {
                    employee.getId(),
                    employee.getName(),
                    employee.getAddress(),
                    employee.getPhone(),
                    StringCommon.getDepartmentString(employee.getDepartment()),
                    employee.getUsername(),};

                rows.add(row);
            }

            String[] headers = {
                "ID",
                I18n.getMessage("employee.name"),
                I18n.getMessage("employee.addr"),
                I18n.getMessage("employee.phone"),
                I18n.getMessage("employee.dept"),
                I18n.getMessage("employee.username")
            };

            TableUI theTable = new TableUI(headers, rows);
            theTable.display();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeListingPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeListingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("employee", "entity.title.all", true);
    }

}
