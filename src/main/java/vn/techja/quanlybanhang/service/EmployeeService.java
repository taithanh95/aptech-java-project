
package vn.techja.quanlybanhang.service;

import java.util.List;
import vn.techja.quanlybanhang.entities.Employee;


public interface EmployeeService extends BaseService<Employee> {

    boolean updateById(Employee object, int id) throws Exception;

    Employee findByUsernameAndPassword(String username, String password) throws Exception;

    List<Employee> findByNameEmployee(String username) throws Exception;

    boolean existsByUsername(String username) throws Exception;
    
    boolean empHasData(Employee emp) throws Exception;
}
