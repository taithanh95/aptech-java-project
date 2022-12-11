/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.menu;

import java.util.LinkedHashMap;
import vn.techja.quanlybanhang.menu.items.ExitMenuItem;
import vn.techja.quanlybanhang.menu.items.GoBackMenuItem;
import vn.techja.quanlybanhang.pages.EmployeeCreatePage;
import vn.techja.quanlybanhang.pages.EmployeeDeletePage;
import vn.techja.quanlybanhang.pages.EmployeeEditPage;
import vn.techja.quanlybanhang.pages.EmployeeListingPage;
import vn.techja.quanlybanhang.pages.EmployeeSearchPage;
import vn.techja.quanlybanhang.utilities.I18n;


public class AdminMenuEmployee extends Menu {

    @Override
    protected LinkedHashMap<Integer, MenuItem> registerMenuItems() {
        LinkedHashMap<Integer, MenuItem> menuItems = new LinkedHashMap<>();

        menuItems.put(1, new EmployeeCreatePage());
        menuItems.put(2, new EmployeeEditPage());
        menuItems.put(3, new EmployeeDeletePage());
        menuItems.put(4, new EmployeeSearchPage());
        menuItems.put(5, new EmployeeListingPage());

        menuItems.put(0, new ExitMenuItem());
        menuItems.put(-1, new GoBackMenuItem());

        return menuItems;
    }

    @Override
    protected String registerMenuTitle() {
        return I18n.getEntityMessage("employee", "entity.title.manage", true);
    }

}
