
package vn.aptech.quanlybanhang.service;

import java.util.List;
import vn.aptech.quanlybanhang.entities.Category;


public interface CategoryService extends BaseService<Category> {

    List<Category> searchByName(String name) throws Exception;
}
