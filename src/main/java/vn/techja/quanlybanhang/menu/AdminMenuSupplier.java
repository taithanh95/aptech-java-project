/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.menu;

import java.util.LinkedHashMap;
import vn.techja.quanlybanhang.menu.items.ExitMenuItem;
import vn.techja.quanlybanhang.menu.items.GoBackMenuItem;
import vn.techja.quanlybanhang.pages.SupplierCreatePage;
import vn.techja.quanlybanhang.pages.SupplierDeletePage;
import vn.techja.quanlybanhang.pages.SupplierDetailPage;
import vn.techja.quanlybanhang.pages.SupplierEditPage;
import vn.techja.quanlybanhang.pages.SupplierListingPage;
import vn.techja.quanlybanhang.pages.SupplierSearchPage;
import vn.techja.quanlybanhang.utilities.I18n;


public class AdminMenuSupplier extends Menu {

    @Override
    protected LinkedHashMap<Integer, MenuItem> registerMenuItems() {
        LinkedHashMap<Integer, MenuItem> menuItems = new LinkedHashMap<>();

        menuItems.put(1, new SupplierCreatePage());
        menuItems.put(2, new SupplierEditPage());
        menuItems.put(3, new SupplierDeletePage());
        menuItems.put(4, new SupplierSearchPage());
        menuItems.put(5, new SupplierDetailPage());
        menuItems.put(6, new SupplierListingPage());

        menuItems.put(0, new ExitMenuItem());
        menuItems.put(-1, new GoBackMenuItem());

        return menuItems;
    }

    @Override
    protected String registerMenuTitle() {
        return I18n.getEntityMessage("supplier", "entity.title.manage", true);
    }
    
}
