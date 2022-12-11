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
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;


public class BrandSearchPage extends Page {

    @Override
    public void displayContent() {
        
        BrandService brandService = new BrandServiceImpl();
        boolean retry = false;
        
        do{
            try {
                System.out.println("");
                String search = AppScanner.scanStringWithi18Message("brand.scan.searchByName");
                System.out.println("");
                
                List<Brand> brands = brandService.searchByName(search);
                
                if (!brands.isEmpty()) {
                    
                    List<Object[]> rows = new ArrayList<>();
                    
                    // transfer data to table row
                    for (Brand brand : brands) {
                        Object[] row = {
                            brand.getId(),
                            brand.getName(),
                            brand.getAddress()
                        };
                        
                        rows.add(row);
                    }
                    
                    String[] headers = {"ID", I18n.getMessage("brand.name"), I18n.getMessage("brand.addr")};
                    
                    TableUI theTable = new TableUI(headers, rows);
                    theTable.display();
                    
                } else {
                    I18n.printEntityMessage("brand", "entity.msg.emptyResults");
                    retry = true;
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(BrandSearchPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(retry);
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("brand", "entity.title.search", true);
    }
    
}
