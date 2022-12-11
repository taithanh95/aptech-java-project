
package vn.aptech.quanlybanhang.dao;

import java.util.List;

import vn.aptech.quanlybanhang.entities.Discount;
import vn.aptech.quanlybanhang.entities.ProductDiscount;


public interface DiscountDAO extends BaseDAO<Discount> {

    List<ProductDiscount> getDiscountProducts(Discount discount);

    boolean deleteDiscountProduct(ProductDiscount dProduct);

    boolean createDiscountProduct(ProductDiscount dProduct);

    ProductDiscount findOverlapDiscountProduct(ProductDiscount dProduct);
    
    boolean discountHasData(Discount discount);
}
