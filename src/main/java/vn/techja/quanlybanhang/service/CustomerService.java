
package vn.techja.quanlybanhang.service;

import vn.techja.quanlybanhang.entities.Customer;


public interface CustomerService extends BaseService<Customer> {

    Customer findByPhone(String phone) throws Exception;
}
