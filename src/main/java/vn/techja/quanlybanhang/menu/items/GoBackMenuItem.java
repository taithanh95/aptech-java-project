/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.menu.items;

import vn.techja.quanlybanhang.menu.Breadcrumb;
import vn.techja.quanlybanhang.menu.MenuItem;
import vn.techja.quanlybanhang.utilities.I18n;


public class GoBackMenuItem extends MenuItem {

    @Override
    public String getTitle() {
        return I18n.getMessage("app.goback");
    }
    
    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void start(){
        Breadcrumb.goBack();
    }
    
}
