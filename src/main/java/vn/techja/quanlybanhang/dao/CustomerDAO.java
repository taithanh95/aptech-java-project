
package vn.techja.quanlybanhang.dao;

import vn.techja.quanlybanhang.entities.Customer;


public interface CustomerDAO extends BaseDAO<Customer> {

    Customer findByPhone(String phone) throws Exception;
}
