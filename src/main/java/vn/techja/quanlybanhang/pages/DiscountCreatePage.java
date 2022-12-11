/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Discount;
import vn.techja.quanlybanhang.entities.Product;
import vn.techja.quanlybanhang.entities.ProductDiscount;
import vn.techja.quanlybanhang.service.DiscountService;
import vn.techja.quanlybanhang.service.DiscountServiceImpl;
import vn.techja.quanlybanhang.service.ProductService;
import vn.techja.quanlybanhang.service.ProductServiceImpl;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;


public class DiscountCreatePage extends Page {

    @Override
    public void displayContent() {

        DiscountService discountService = new DiscountServiceImpl();

        String discountName = AppScanner.scanStringWithMessage(I18n.getMessage("discount.scan.name"));

        try {

            Discount discount = new Discount(discountName);

            if (AppScanner.confirm(I18n.getMessage("discount.confirm.addProduct"))) {

                List<ProductDiscount> dProducts = new ArrayList<>();

                do {
                    ProductDiscount dProduct = this.scanNewDiscountProduct();
                    ProductDiscount oDisProduct = discountService.findOverlapDiscountProduct(dProduct);

                    if (oDisProduct != null) {
                        I18n.print("discount.error.overlapTimeRange");
                    } else {
                        dProducts.add(dProduct);
                    }

                } while (AppScanner.confirm(I18n.getMessage("discount.confirm.addAnotherProduct")));

                discount.setProductDiscounts(dProducts);

            }

            if (!discountService.create(discount) || discount.getId() == 0) {
                I18n.printEntityMessage("discount", "entity.error.createFailed");
            } else {
                I18n.printEntityMessage("discount", "entity.msg.created");
            }

        } catch (Exception ex) {
            Logger.getLogger(DiscountCreatePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("discount", "entity.title.create");
    }

    private ProductDiscount scanNewDiscountProduct() {

        /**
         * input product_id
         */
        Product product = null;
        ProductService productService = new ProductServiceImpl();
        try {
            while (product == null) {

                product = productService.findById(AppScanner.scanIntWithi18Message("discount.scan.productId"));

                if (product == null) {
                    I18n.printEntityMessage("product", "entity.error.idNotFound");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DiscountCreatePage.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        ProductDiscount pDiscount = new ProductDiscount();
        pDiscount.setDiscountPercentage(pDiscount.scanDiscountPercentage());
        pDiscount.setProduct(product);
        pDiscount.setStartDate(pDiscount.scanStartDate());
        pDiscount.setEndDate(pDiscount.scanEndDate(pDiscount.getStartDate()));

        return pDiscount;
    }

}
