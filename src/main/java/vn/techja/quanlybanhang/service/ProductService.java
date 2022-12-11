
package vn.techja.quanlybanhang.service;

import java.util.Date;
import vn.techja.quanlybanhang.entities.Brand;
import vn.techja.quanlybanhang.entities.Category;
import vn.techja.quanlybanhang.entities.Product;
import vn.techja.quanlybanhang.entities.Supplier;
import vn.techja.quanlybanhang.utilities.PaginatedResults;


public interface ProductService extends BaseService<Product> {

    public PaginatedResults<Product> findByCategoryId(int page, int id) throws Exception;

    /**
     *
     * @param page
     * @param name
     * @return
     * @throws java.lang.Exception
     */
    public PaginatedResults<Product> findByName(int page, String name) throws Exception;

    public PaginatedResults<Product> selectOutOfStock(int page) throws Exception;

    PaginatedResults<Product> findAllByOrderByUnitsOnOrderDesc(int page, String fromDate, String toDate) throws Exception;

    double getStatisticAmount(Date fromDate, Date toDate) throws Exception;

    boolean productHasOrder(Product product) throws Exception;

    Product findFirstProductByBrand(Brand brand) throws Exception;

    Product findFirstProductBySupplier(Supplier sup) throws Exception;

    Product findFirstProductByCategory(Category cat) throws Exception;
}
