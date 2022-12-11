/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.menu;

import java.util.LinkedHashMap;
import vn.techja.quanlybanhang.menu.items.ExitMenuItem;
import vn.techja.quanlybanhang.menu.items.GoBackMenuItem;
import vn.techja.quanlybanhang.pages.CategoryCreatePage;
import vn.techja.quanlybanhang.pages.CategoryDeletePage;
import vn.techja.quanlybanhang.pages.CategoryDetailPage;
import vn.techja.quanlybanhang.pages.CategoryEditPage;
import vn.techja.quanlybanhang.pages.CategoryListingPage;
import vn.techja.quanlybanhang.pages.CategorySearchPage;
import vn.techja.quanlybanhang.utilities.I18n;


public class InventoryMenuCategory extends Menu {

     @Override
    protected LinkedHashMap<Integer, MenuItem> registerMenuItems() {
        LinkedHashMap<Integer, MenuItem> menuItems = new LinkedHashMap<>();

        menuItems.put(1, new CategoryCreatePage());
        menuItems.put(2, new CategoryEditPage());
        menuItems.put(3, new CategoryDeletePage());
        menuItems.put(4, new CategoryListingPage());
        menuItems.put(5, new CategorySearchPage());
        menuItems.put(6, new CategoryDetailPage());

        menuItems.put(0, new ExitMenuItem());
        menuItems.put(-1, new GoBackMenuItem());

        return menuItems;
    }

    @Override
    protected String registerMenuTitle() {
        return I18n.getEntityMessage("category", "entity.title.manage", true);
    }
    
}
