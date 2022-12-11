
package vn.techja.quanlybanhang.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Category;
import vn.techja.quanlybanhang.service.CategoryService;
import vn.techja.quanlybanhang.service.CategoryServiceImpl;
import vn.techja.quanlybanhang.service.ProductService;
import vn.techja.quanlybanhang.service.ProductServiceImpl;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;


public class CategoryDeletePage extends Page {

    @Override
    public void displayContent() {
        try {

            CategoryService categoryService = new CategoryServiceImpl();
            ProductService productService = new ProductServiceImpl();
            
            while (true) {

                int id = AppScanner.scanIntWithMessage(I18n.getEntityMessage("category", "entity.scan.id.delete"));

                Category theCat = categoryService.findById(id);

                if (theCat == null) {
                    I18n.printEntityMessage("category", "entity.error.idNotFound");
                    continue;
                }

                System.out.println("");
                I18n.print("entity.msg.foundName", I18n.getMessage("category.label.singular"), theCat.getName());
                System.out.println("");

                if (AppScanner.confirm(I18n.getEntityMessage("category", "entity.confirm.delete"))) {
                    if (productService.findFirstProductByCategory(theCat) != null) {
                        I18n.print("category.error.delete");
                    } else if (categoryService.deleteById(theCat.getId())) {
                        I18n.printEntityMessage("category", "entity.msg.deleted");
                    } else {
                        I18n.printEntityMessage("category", "entity.error.deleteFailed");
                    }
                }
                
                System.out.println("");
                if (!AppScanner.confirm(I18n.getEntityMessage("category", "entity.confirm.deleteAnother"))) {
                    System.out.println("");
                    break;
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(CategoryEditPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("category", "entity.title.delete");
    }

}
