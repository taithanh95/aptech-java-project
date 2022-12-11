
package vn.aptech.quanlybanhang.service;

import java.util.List;

import vn.aptech.quanlybanhang.entities.Supplier;


public interface SupplierService extends BaseService<Supplier> {

    public List<Supplier> searchByName(String name) throws Exception;

}
