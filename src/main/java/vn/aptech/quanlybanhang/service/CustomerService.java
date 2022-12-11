
package vn.aptech.quanlybanhang.service;

import vn.aptech.quanlybanhang.entities.Customer;


public interface CustomerService extends BaseService<Customer> {

    Customer findByPhone(String phone) throws Exception;
}
