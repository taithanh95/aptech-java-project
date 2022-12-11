/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.menu.items;

import vn.techja.quanlybanhang.Main;
import vn.techja.quanlybanhang.menu.MenuItem;
import vn.techja.quanlybanhang.service.AuthServiceImpl;
import vn.techja.quanlybanhang.ui.HelperUI;
import vn.techja.quanlybanhang.utilities.I18n;


public class SignoutMenuItem extends MenuItem {

    @Override
    public String getTitle() {
        return I18n.getMessage("app.signout");
    }

    @Override
    public void display() {
        AuthServiceImpl.logout();
        
        HelperUI.displayMargin();
        I18n.getMessage("app.msg.signedOut");
        
        Main.start();
    }
    
}
