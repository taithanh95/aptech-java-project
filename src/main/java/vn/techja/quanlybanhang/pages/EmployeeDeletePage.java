/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.pages;

import vn.techja.quanlybanhang.entities.Employee;
import vn.techja.quanlybanhang.service.EmployeeService;
import vn.techja.quanlybanhang.service.EmployeeServiceImpl;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;

public class EmployeeDeletePage extends Page {

    private final EmployeeService employeeService;

    public EmployeeDeletePage() {
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public void displayContent() {

        while (true) {
            try {
                int employeeId = AppScanner.scanIntWithMessage(I18n.getEntityMessage("employee", "entity.scan.id.delete"));
                Employee employee = employeeService.findById(employeeId);
                if (employee == null) {
                    I18n.printEntityMessage("employee", "entity.error.idNotFound");
                    continue;
                }
                I18n.print("entity.msg.foundName", I18n.getMessage("employee.label.singular"), employee.getName());
                if (AppScanner.confirm(I18n.getEntityMessage("employee", "entity.confirm.delete"))) {
                    if (employeeService.empHasData(employee)) {
                        I18n.print("employee.error.preventDelete");
                    } else if (employeeService.deleteById(employeeId)) {
                        I18n.printEntityMessage("employee", "entity.msg.deleted");
                    } else {
                        I18n.printEntityMessage("employee", "entity.error.deleteFailed");
                    }
                }
                if (!AppScanner.confirm(I18n.getEntityMessage("employee", "entity.confirm.deleteAnother"))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("employee", "entity.title.delete");
    }

}
