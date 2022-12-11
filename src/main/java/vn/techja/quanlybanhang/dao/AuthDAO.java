
package vn.techja.quanlybanhang.dao;

import vn.techja.quanlybanhang.entities.Employee;


public interface AuthDAO {

    Employee login(String username, String password);

    Employee findById(int id);
}
