/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.pages;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Discount;
import vn.techja.quanlybanhang.service.DiscountService;
import vn.techja.quanlybanhang.service.DiscountServiceImpl;
import vn.techja.quanlybanhang.ui.TableUI;
import vn.techja.quanlybanhang.utilities.I18n;


public class DiscountListingPage extends Page {

    @Override
    public void displayContent() {
        DiscountService discountService = new DiscountServiceImpl();
        do {            
            try {
                List<Discount> discounts = discountService.findAll();
                if (discounts.isEmpty()) {
                    I18n.printEntityMessage("discount", "entity.msg.emptyResults");
                } else {
                    List<Object[]> rows = new ArrayList<>();
                    for (Discount discount : discounts) {
                        Object[] row = {
                            discount.getId(),
                            discount.getName(),
                            discount.getProductCount()
                        };
                        rows.add(row);
                    }
                    String[] headers = {"ID", I18n.getMessage("discount.name"), I18n.getMessage("discount.productsCount")};
                    TableUI tableUI = new TableUI(headers,rows);
                    tableUI.display();
                    break;
                }
            }catch (SQLException e) {
                System.out.println("Exception when ProductMenu.handleSearch: " + e.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(DiscountListingPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
        
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("discount", "entity.title.all", true);
    }

}
