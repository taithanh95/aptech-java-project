
package vn.techja.quanlybanhang.dao;

import java.util.List;
import vn.techja.quanlybanhang.entities.Supplier;


public interface SupplierDAO extends BaseDAO<Supplier> {

    List<Supplier> searchByName(String Name) throws Exception;

}
