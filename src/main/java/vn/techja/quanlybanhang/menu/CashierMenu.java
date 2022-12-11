/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.menu;

import java.util.LinkedHashMap;
import vn.techja.quanlybanhang.menu.items.ExitMenuItem;
import vn.techja.quanlybanhang.menu.items.SignoutMenuItem;
import vn.techja.quanlybanhang.pages.CashierStatisticPage;
import vn.techja.quanlybanhang.pages.ChangePasswordPage;
import vn.techja.quanlybanhang.pages.OrderCreatePage;
import vn.techja.quanlybanhang.utilities.I18n;


public class CashierMenu extends Menu {

    @Override
    protected LinkedHashMap<Integer, MenuItem> registerMenuItems() {
        LinkedHashMap<Integer, MenuItem> menuItems = new LinkedHashMap<>();

        menuItems.put(1, new OrderCreatePage());
        menuItems.put(2, new CashierMenuOrder());
        menuItems.put(3, new CashierMenuProduct());
        menuItems.put(4, new CashierMenuCategory());
        menuItems.put(5, new CashierMenuCustomer());
        menuItems.put(6, new ChangePasswordPage());
        menuItems.put(7, new CashierStatisticPage());

        menuItems.put(-1, new SignoutMenuItem());
        menuItems.put(0, new ExitMenuItem());

        return menuItems;
    }

    @Override
    protected final String registerMenuTitle() {
        return I18n.getMessage("app.heading");
    }

    @Override
    public String getBreadcrumbPathName() {
        return "Menu";
    }

}
