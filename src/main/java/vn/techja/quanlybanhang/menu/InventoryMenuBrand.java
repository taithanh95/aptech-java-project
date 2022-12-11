/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.menu;

import java.util.LinkedHashMap;
import vn.techja.quanlybanhang.menu.items.ExitMenuItem;
import vn.techja.quanlybanhang.menu.items.GoBackMenuItem;
import vn.techja.quanlybanhang.pages.BrandCreatePage;
import vn.techja.quanlybanhang.pages.BrandDeletePage;
import vn.techja.quanlybanhang.pages.BrandEditPage;
import vn.techja.quanlybanhang.pages.BrandListingPage;
import vn.techja.quanlybanhang.pages.BrandSearchPage;
import vn.techja.quanlybanhang.utilities.I18n;


public class InventoryMenuBrand extends Menu {

    @Override
    protected LinkedHashMap<Integer, MenuItem> registerMenuItems() {
        LinkedHashMap<Integer, MenuItem> menuItems = new LinkedHashMap<>();
        
        menuItems.put(1, new BrandListingPage());
        menuItems.put(2, new BrandCreatePage());
        menuItems.put(3, new BrandEditPage());
        menuItems.put(4, new BrandDeletePage());
        menuItems.put(5, new BrandSearchPage());
        
        menuItems.put(0, new ExitMenuItem());
        menuItems.put(-1, new GoBackMenuItem());
        
        return menuItems;
    }

    @Override
    protected String registerMenuTitle() {
        return I18n.getEntityMessage("brand", "entity.title.manage", true);
    }
    
}
