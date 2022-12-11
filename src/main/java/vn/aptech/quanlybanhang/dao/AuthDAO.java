
package vn.aptech.quanlybanhang.dao;

import vn.aptech.quanlybanhang.entities.Employee;


public interface AuthDAO {

    Employee login(String username, String password);

    Employee findById(int id);
}
