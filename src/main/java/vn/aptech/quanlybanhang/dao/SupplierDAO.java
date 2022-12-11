
package vn.aptech.quanlybanhang.dao;

import java.util.List;

import vn.aptech.quanlybanhang.entities.Supplier;


public interface SupplierDAO extends BaseDAO<Supplier> {

    List<Supplier> searchByName(String Name) throws Exception;

}
