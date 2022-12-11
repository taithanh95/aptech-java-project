
package vn.techja.quanlybanhang.pages;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import vn.techja.quanlybanhang.entities.ImportProduct;
import vn.techja.quanlybanhang.service.ImportProductService;
import vn.techja.quanlybanhang.service.ImportProductServiceImpl;
import vn.techja.quanlybanhang.ui.TableUI;
import vn.techja.quanlybanhang.utilities.I18n;


public class ImportProductHistoryPage extends Page {

    private final ImportProductService importProductService;

    public ImportProductHistoryPage() {
        this.importProductService = new ImportProductServiceImpl();
    }

    @Override
    public void displayContent() {
        try {

            I18n.getMessage("product.import.msg.recently");

            List<ImportProduct> importProducts = importProductService.findAll();
            if (importProducts.isEmpty()) {
                I18n.printEntityMessage("product", "entity.msg.emptyResults");
            } else {
                List<Object[]> rows = new ArrayList<>();

                // transfer data to table row
                for (ImportProduct importProduct : importProducts) {
                    Object[] row = {
                        importProduct.getId(),
                        importProduct.getPriceString(),
                        importProduct.getQtyString(),
                        importProduct.getSupplier().getName(),
                        importProduct.getCreatedAtString(),};

                    rows.add(row);
                }

                String[] headers = {
                    "ID",
                    I18n.getMessage("product.price"),
                    I18n.getMessage("product.qty"),
                    I18n.getMessage("supplier.label.singular"),
                    I18n.getMessage("product.import.datetime")
                };

                TableUI theTable = new TableUI(headers, rows);
                theTable.display();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportProductHistoryPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImportProductHistoryPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getTitle() {
        return I18n.getMessage("product.import.title.history");
    }

}
