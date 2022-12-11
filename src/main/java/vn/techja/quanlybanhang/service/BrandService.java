
package vn.techja.quanlybanhang.service;

import java.sql.SQLException;
import java.util.List;
import vn.techja.quanlybanhang.entities.Brand;


public interface BrandService extends BaseService<Brand> {

    public List<Brand> searchByName(String search) throws SQLException, ClassNotFoundException;
}
