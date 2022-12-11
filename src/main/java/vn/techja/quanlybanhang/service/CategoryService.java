
package vn.techja.quanlybanhang.service;

import java.util.List;
import vn.techja.quanlybanhang.entities.Category;


public interface CategoryService extends BaseService<Category> {

    List<Category> searchByName(String name) throws Exception;
}
