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
import vn.techja.quanlybanhang.entities.Brand;
import vn.techja.quanlybanhang.service.BrandService;
import vn.techja.quanlybanhang.service.BrandServiceImpl;
import vn.techja.quanlybanhang.ui.TableUI;
import vn.techja.quanlybanhang.utilities.I18n;
import vn.techja.quanlybanhang.utilities.PaginatedResults;


public class BrandListingPage extends Page {

    @Override
    public void displayContent() {
        try {

            int page = 1;

            do {

                BrandService brandService = new BrandServiceImpl();
                PaginatedResults<Brand> results = brandService.select(page);
                
                if(results.getResults().isEmpty()) {
                    I18n.printEntityMessage("brand", "entity.msg.emptyResults");
                    return;
                }
                
                // transfer data to table row
                List<Object[]> rows = new ArrayList<>();
                for (Brand brand : results.getResults()) {
                    Object[] row = {
                        brand.getId(),
                        brand.getName(),
                        brand.getAddress()
                    };

                    rows.add(row);
                }

                String[] headers = {"ID", I18n.getMessage("brand.name"), I18n.getMessage("brand.addr")};

                TableUI theTable = new TableUI(headers, rows);
                theTable.display(); //table
                
                if(results.needsPagination()) {
                    results.displayPagination(); //pagination
                    results.displayPaginationMenu(); //pagination menu

                    page = results.scanGoPage();

                    System.out.println("");
                } else {
                    page = 0; 
               }
               
                
            } while (page > 0);

        } catch (SQLException ex) {
            Logger.getLogger(BrandListingPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BrandListingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("brand", "entity.title.all", true);
    }

}
