/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Brand;
import vn.techja.quanlybanhang.service.BrandService;
import vn.techja.quanlybanhang.service.BrandServiceImpl;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;


public class BrandCreatePage extends Page {

    @Override
    public void displayContent() {
        
        try {
            BrandService brandService = new BrandServiceImpl();
            
            Brand brand = new Brand();
            
            brand.setName(AppScanner.scanStringWithi18Message("brand.scan.name"));
            brand.setAddress(AppScanner.scanStringWithi18Message("brand.scan.address"));
            
            brandService.create(brand);
            
            I18n.printEntityMessage("brand", "entity.msg.created");
        } catch (Exception ex) {
            Logger.getLogger(BrandCreatePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("brand", "entity.title.create");
    }
    
}
