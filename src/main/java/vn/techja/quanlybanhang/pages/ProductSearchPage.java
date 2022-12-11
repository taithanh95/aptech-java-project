
package vn.techja.quanlybanhang.pages;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.techja.quanlybanhang.entities.Product;
import vn.techja.quanlybanhang.service.ProductService;
import vn.techja.quanlybanhang.service.ProductServiceImpl;
import vn.techja.quanlybanhang.utilities.AppScanner;
import vn.techja.quanlybanhang.utilities.I18n;
import vn.techja.quanlybanhang.utilities.PaginatedResults;


public class ProductSearchPage extends Page {

    private final ProductService productService;

    public ProductSearchPage() {
        this.productService = new ProductServiceImpl();
    }

    @Override
    public void displayContent() {

        
        try {
            
            while(true) {
                
                int page = 1;
                
                String search = AppScanner.scanStringWithMessage(I18n.getMessage("product.scan.searchName"));
                
                do {
                    
                    PaginatedResults<Product> products = productService.findByName(page, search);

                    if (products.getResults().isEmpty()) {
                        I18n.printEntityMessage("product", "entity.msg.emptyResults");
                        break;
                    }

                    I18n.print("entity.msg.foundBaseOn", I18n.getMessage("product.label.plural"), search);

                    Product.toTable(products.getResults()).display();

                    if (products.needsPagination()) {
                        products.displayPagination();
                        products.displayPaginationMenu();
                        page = products.scanGoPage();
                        System.out.println("");
                    } else {
                        page = 0;
                    }
                    
                } while (page > 0);
                
                if (!AppScanner.confirm(I18n.getMessage("entity.confirm.searchAnOther"))) {
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductSearchPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductSearchPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTitle() {
        return I18n.getEntityMessage("product", "entity.title.search", true);
    }

}
