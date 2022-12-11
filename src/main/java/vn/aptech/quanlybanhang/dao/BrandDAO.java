
package vn.aptech.quanlybanhang.dao;

import java.util.List;
import vn.aptech.quanlybanhang.entities.Brand;


public interface BrandDAO extends BaseDAO<Brand> {

    List<Brand> searchByName(String name) throws Exception;
}
