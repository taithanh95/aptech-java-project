
package vn.techja.quanlybanhang.menu;

import java.util.LinkedHashMap;
import vn.techja.quanlybanhang.menu.items.ExitMenuItem;
import vn.techja.quanlybanhang.menu.items.GoBackMenuItem;
import vn.techja.quanlybanhang.pages.CustomerCreatePage;
import vn.techja.quanlybanhang.pages.CustomerDeletePage;

import vn.techja.quanlybanhang.pages.CustomerEditPage;
import vn.techja.quanlybanhang.pages.CustomerListingPage;
import vn.techja.quanlybanhang.pages.CustomerSearchByIDPage;
import vn.techja.quanlybanhang.pages.CustomerSearchByPhonePage;
import vn.techja.quanlybanhang.utilities.I18n;


public class AdminMenuCustomer extends Menu {

    @Override
    protected LinkedHashMap<Integer, MenuItem> registerMenuItems() {
        LinkedHashMap<Integer, MenuItem> menuItems = new LinkedHashMap<>();


        menuItems.put(1, new CustomerCreatePage());
        menuItems.put(2, new CustomerEditPage());
        menuItems.put(3, new CustomerSearchByIDPage());
        menuItems.put(4, new CustomerSearchByPhonePage());
        menuItems.put(5, new CustomerListingPage());
        menuItems.put(6, new CustomerDeletePage());

        menuItems.put(0, new ExitMenuItem());
        menuItems.put(-1, new GoBackMenuItem());
        return menuItems;
    }

    @Override
    protected String registerMenuTitle() {
        return I18n.getEntityMessage("customer", "entity.title.manage", true);
    }

}
