
package vn.techja.quanlybanhang.service;

import java.sql.SQLException;
import java.util.List;
import vn.techja.quanlybanhang.dao.DiscountDAO;
import vn.techja.quanlybanhang.dao.DiscountDAOImpl;
import vn.techja.quanlybanhang.entities.Discount;
import vn.techja.quanlybanhang.entities.ProductDiscount;
import vn.techja.quanlybanhang.utilities.I18n;
import vn.techja.quanlybanhang.utilities.PaginatedResults;

public class DiscountServiceImpl implements DiscountService {

    private final DiscountDAO discountDAO;

    public DiscountServiceImpl() {
        this.discountDAO = new DiscountDAOImpl();
    }

    @Override
    public boolean create(Discount object) throws SQLException, Exception {
        if (object == null) {
            throw new Exception(I18n.getMessage("app.error.object.null"));
        }
        return discountDAO.create(object);
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        if (id < 1) {
            throw new Exception(I18n.getMessage("input.invalidID"));
        }
        return discountDAO.deleteById(id);
    }

    @Override
    public Discount findById(int id) throws Exception {
        if (id < 1) {
            throw new Exception(I18n.getMessage("input.invalidID"));
        }
        return discountDAO.findById(id);
    }

    @Override
    public List<Discount> findAll() throws Exception {
        return discountDAO.findAll();
    }

    @Override
    public boolean update(Discount object) throws Exception {
        return this.discountDAO.update(object);
    }

    @Override
    public PaginatedResults<Discount> select(int page) throws Exception {
        return this.discountDAO.select(page);
    }

    @Override
    public List<ProductDiscount> getDiscountProducts(Discount discount) {
        return this.discountDAO.getDiscountProducts(discount);
    }

    @Override
    public boolean deleteDiscountProduct(ProductDiscount dProduct) {
        return this.discountDAO.deleteDiscountProduct(dProduct);
    }

    @Override
    public boolean createDiscountProduct(ProductDiscount dProduct) {
        return this.discountDAO.createDiscountProduct(dProduct);
    }

    @Override
    public ProductDiscount findOverlapDiscountProduct(ProductDiscount dProduct) {
        return this.discountDAO.findOverlapDiscountProduct(dProduct);
    }

    @Override
    public boolean discountHasData(Discount discount) {
        return this.discountDAO.discountHasData(discount);
    }

}
