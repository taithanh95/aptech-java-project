/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.pages;

import java.util.ArrayList;
import java.util.List;

import vn.techja.quanlybanhang.entities.Supplier;
import vn.techja.quanlybanhang.service.SupplierService;
import vn.techja.quanlybanhang.service.SupplierServiceImpl;
import vn.techja.quanlybanhang.ui.TableUI;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;


public class SupplierDetailPage extends Page {

    @Override
    public void displayContent() {
        SupplierService supplierService = new SupplierServiceImpl();
        String choice = null;
        do {           
            try {
                int supplierId = AppScanner.scanIntWithMessage(I18n.getEntityMessage("supplier", "entity.scan.id.detail"));
                Supplier supplier = supplierService.findById(supplierId);
                if (supplier == null) {
                    I18n.printEntityMessage("supplier", "entity.error.idNotFound");
                } else {
                    List<Object[]> rows = new ArrayList<>();
                    Object[] row = {
                        supplier.getId(),
                        supplier.getName(),
                        supplier.getAddress()
                    };
                    rows.add(row);
                    
                    String[] headers = {"ID", I18n.getMessage("supplier.name"), I18n.getMessage("supplier.addr")};
                    TableUI theTable = new TableUI(headers, rows);
                    theTable.display();
                    choice = AppScanner.scanStringWithMessage(I18n.getEntityMessage("supplier", "entity.confirm.findMore"));
                    if (!"y".equalsIgnoreCase(choice)) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } 
        } while ("y".equalsIgnoreCase(choice));
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("supplier", "entity.title.detail");
    }
    
}
