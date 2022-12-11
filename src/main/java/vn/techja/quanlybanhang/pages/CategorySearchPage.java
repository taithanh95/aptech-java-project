
package vn.techja.quanlybanhang.pages;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Category;
import vn.techja.quanlybanhang.service.CategoryService;
import vn.techja.quanlybanhang.service.CategoryServiceImpl;
import vn.techja.quanlybanhang.ui.TableUI;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;


public class CategorySearchPage extends Page {

    @Override
    public void displayContent() {

        String keyword = AppScanner.scanStringWithMessage(I18n.getEntityMessage("category", "entity.scan.searchKeyword"));

        CategoryService categoryService = new CategoryServiceImpl();

        try {
            List<Category> categories = categoryService.searchByName(keyword);
            List<Object[]> rows = new ArrayList<>();
            if (categories.isEmpty()) {
                I18n.printEntityMessage("category", "entity.msg.emptyResults");
            } else {
                // transfer data to table row
                for (Category cat : categories) {
                    Object[] row = {
                        cat.getId(),
                        cat.getName(),
                        cat.getProductCount()
                    };

                    rows.add(row);
                }

                String[] headers = {"ID", I18n.getMessage("category.name"), I18n.getMessage("category.productsCount")};

                TableUI theTable = new TableUI(headers, rows);
                theTable.display();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorySearchPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CategorySearchPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("category", "entity.title.search", true);
    }

}
