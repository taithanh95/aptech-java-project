
package vn.aptech.quanlybanhang.service;

import java.util.List;

import vn.aptech.quanlybanhang.entities.Discount;
import vn.aptech.quanlybanhang.entities.ProductDiscount;


public interface DiscountService extends BaseService<Discount> {

    List<ProductDiscount> getDiscountProducts(Discount discount);

    boolean deleteDiscountProduct(ProductDiscount dProduct);

    boolean createDiscountProduct(ProductDiscount dProduct);

    ProductDiscount findOverlapDiscountProduct(ProductDiscount dProduct);
    
    boolean discountHasData(Discount discount);
}
