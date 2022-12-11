/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.menu;

import java.util.LinkedHashMap;
import vn.techja.quanlybanhang.menu.items.ExitMenuItem;
import vn.techja.quanlybanhang.menu.items.GoBackMenuItem;
import vn.techja.quanlybanhang.pages.OrderDetailPage;
import vn.techja.quanlybanhang.pages.OrderListingPage;
import vn.techja.quanlybanhang.pages.OrderSearchByCustomerPage;
import vn.techja.quanlybanhang.pages.OrderSearchByDatePage;
import vn.techja.quanlybanhang.utilities.I18n;


public class InventoryMenuOrder extends Menu {

    @Override
    protected LinkedHashMap<Integer, MenuItem> registerMenuItems() {
        LinkedHashMap<Integer, MenuItem> menuItems = new LinkedHashMap<>();

        menuItems.put(1, new OrderDetailPage());
        menuItems.put(2, new OrderListingPage());
        menuItems.put(3, new OrderSearchByCustomerPage());
        menuItems.put(4, new OrderSearchByDatePage());

        menuItems.put(0, new ExitMenuItem());
        menuItems.put(-1, new GoBackMenuItem());

        return menuItems;
    }

    @Override
    protected String registerMenuTitle() {
        return I18n.getEntityMessage("order", "entity.title.manage", true);
    }
    
}
