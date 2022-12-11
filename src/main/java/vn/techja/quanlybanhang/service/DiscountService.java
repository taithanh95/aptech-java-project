
package vn.techja.quanlybanhang.service;

import java.util.List;
import vn.techja.quanlybanhang.entities.Discount;
import vn.techja.quanlybanhang.entities.ProductDiscount;


public interface DiscountService extends BaseService<Discount> {

    List<ProductDiscount> getDiscountProducts(Discount discount);

    boolean deleteDiscountProduct(ProductDiscount dProduct);

    boolean createDiscountProduct(ProductDiscount dProduct);

    ProductDiscount findOverlapDiscountProduct(ProductDiscount dProduct);
    
    boolean discountHasData(Discount discount);
}
