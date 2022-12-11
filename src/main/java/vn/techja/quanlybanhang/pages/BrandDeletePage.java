/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Brand;
import vn.techja.quanlybanhang.exception.InputInvalidException;
import vn.techja.quanlybanhang.service.ProductService;
import vn.techja.quanlybanhang.service.ProductServiceImpl;
import vn.techja.quanlybanhang.service.BrandService;
import vn.techja.quanlybanhang.service.BrandServiceImpl;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;


public class BrandDeletePage extends Page {

    @Override
    public void displayContent() {
        
        BrandService brandService = new BrandServiceImpl();
        ProductService productService = new ProductServiceImpl();
        
        while(true){
            
            try{
                int id = AppScanner.scanIntWithMessage(I18n.getEntityMessage("brand", "entity.scan.id.delete"));
                Brand brand = brandService.findById(id);

                if (brand == null) {
                    I18n.printEntityMessage("brand", "entity.error.idNotFound");
                    continue;
                } 
                
                System.out.println("");
                I18n.print("entity.msg.foundName", I18n.getMessage("brand.label.singular"), brand.getName());
                System.out.println("");
                
                if (AppScanner.confirm(I18n.getEntityMessage("brand", "entity.confirm.delete"))) {
                    if (productService.findFirstProductByBrand(brand) != null) {
                        I18n.print("brand.error.delete");
                    } else if (brandService.deleteById(brand.getId())) {
                        I18n.printEntityMessage("brand", "entity.msg.deleted");
                    } else {
                        I18n.printEntityMessage("brand", "entity.error.deleteFailed");
                    }
                }
                
                System.out.println("");
                if (!AppScanner.confirm(I18n.getEntityMessage("brand", "entity.confirm.deleteAnother"))) {
                    System.out.println("");
                    break;
                }
            }catch(InputInvalidException e){
                System.out.println(e.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(BrandDeletePage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("brand", "entity.title.delete");
    }
    
}
