
package vn.techja.quanlybanhang.dao;

import java.util.List;
import vn.techja.quanlybanhang.entities.Discount;
import vn.techja.quanlybanhang.entities.ProductDiscount;


public interface DiscountDAO extends BaseDAO<Discount> {

    List<ProductDiscount> getDiscountProducts(Discount discount);

    boolean deleteDiscountProduct(ProductDiscount dProduct);

    boolean createDiscountProduct(ProductDiscount dProduct);

    ProductDiscount findOverlapDiscountProduct(ProductDiscount dProduct);
    
    boolean discountHasData(Discount discount);
}
