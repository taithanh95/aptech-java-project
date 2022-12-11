/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.menu.items;

import vn.techja.quanlybanhang.menu.MenuItem;
import vn.techja.quanlybanhang.utilities.I18n;


public class ExitMenuItem extends MenuItem {

    @Override
    public void display() {
        System.exit(0);
    }

    @Override
    public String getTitle() {
        return I18n.getMessage("app.exit");
    }
    
}
