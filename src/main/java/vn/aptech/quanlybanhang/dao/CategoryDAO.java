
package vn.aptech.quanlybanhang.dao;

import java.util.List;

import vn.aptech.quanlybanhang.entities.Category;


public interface CategoryDAO extends BaseDAO<Category> {

    List<Category> searchByName(String name) throws Exception;
}
