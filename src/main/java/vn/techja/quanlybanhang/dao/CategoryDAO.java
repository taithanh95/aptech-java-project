
package vn.techja.quanlybanhang.dao;

import java.util.List;
import vn.techja.quanlybanhang.entities.Category;


public interface CategoryDAO extends BaseDAO<Category> {

    List<Category> searchByName(String name) throws Exception;
}
