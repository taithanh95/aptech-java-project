
package vn.techja.quanlybanhang.service;

import vn.techja.quanlybanhang.entities.Employee;


public interface AuthService {

    Employee login(String username, String password);

}
