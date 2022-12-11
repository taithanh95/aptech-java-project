
package vn.aptech.quanlybanhang.dao;

import vn.aptech.quanlybanhang.entities.Category;
import vn.aptech.quanlybanhang.entities.Product;
import vn.aptech.quanlybanhang.entities.Supplier;
import vn.aptech.quanlybanhang.utilities.PaginatedResults;
import vn.aptech.quanlybanhang.entities.Brand;


public interface ProductDAO extends BaseDAO<Product> {

    PaginatedResults<Product> findByCategoryId(int page, int id) throws Exception;

    PaginatedResults<Product> findByName(int page, String name) throws Exception;

    PaginatedResults<Product> selectOutOfStock(int page) throws Exception;

    PaginatedResults<Product> findAllByOrderByUnitsOnOrderDesc(int page, String fromDate, String toDate) throws Exception;

    double getStatisticAmount(java.sql.Date fromDate, java.sql.Date toDate) throws Exception;
    
    boolean productHasOrder(Product product) throws Exception;
    
    Product findFirstProductByBrand(Brand brand) throws Exception;
    Product findFirstProductBySupplier(Supplier sup) throws Exception;
    Product findFirstProductByCategory(Category cat) throws Exception;
}
