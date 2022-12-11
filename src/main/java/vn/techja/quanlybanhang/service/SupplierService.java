
package vn.techja.quanlybanhang.service;

import java.util.List;
import vn.techja.quanlybanhang.entities.Supplier;


public interface SupplierService extends BaseService<Supplier> {

    public List<Supplier> searchByName(String name) throws Exception;

}
