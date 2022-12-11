
package vn.aptech.quanlybanhang.dao;

import vn.aptech.quanlybanhang.entities.Customer;


public interface CustomerDAO extends BaseDAO<Customer> {

    Customer findByPhone(String phone) throws Exception;
}
