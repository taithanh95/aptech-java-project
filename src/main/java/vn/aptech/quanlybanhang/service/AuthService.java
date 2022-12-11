
package vn.aptech.quanlybanhang.service;

import vn.aptech.quanlybanhang.entities.Employee;


public interface AuthService {

    Employee login(String username, String password);

}
