
package vn.techja.quanlybanhang.dao;

import java.util.List;
import vn.techja.quanlybanhang.entities.Brand;


public interface BrandDAO extends BaseDAO<Brand> {

    List<Brand> searchByName(String name) throws Exception;
}
