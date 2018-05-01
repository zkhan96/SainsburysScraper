import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableDataCell;
import java.util.Optional;

class ProductHtmlParser {

    private  final String XPATH_OF_PRODUCT_ANCHOR = "div[contains(@class, 'productInfo')]/div[contains(@class, 'productNameAndPromotions')]/h3/a";
    private  final String XPATH_FOR_NUTRITIONAL_VALUE = "//table[contains(@class, 'nutritionTable')]/tbody/tr[contains(@class, 'tableRow1')]/td[contains(@class, 'tableRow1')]";


    Optional<Product> buildProduct(HtmlDivision htmlProduct) {
        return htmlProduct != null
            ? Optional.of(new Product(
                getProductName(htmlProduct),
                getkCalPer100g(htmlProduct), 0.0, ""))
            : Optional.empty();
    }

    private String getkCalPer100g(HtmlDivision htmlProduct) {
        HtmlPage productPage;
        try {
            HtmlAnchor productAnchor = htmlProduct.getFirstByXPath(XPATH_OF_PRODUCT_ANCHOR);
            if (productAnchor == null) {
                return null;
            }
            productPage = productAnchor.click();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        HtmlTableDataCell energyTableCell = productPage.getFirstByXPath(XPATH_FOR_NUTRITIONAL_VALUE);
        return energyTableCell != null ? energyTableCell.getTextContent() : null;
    }

    private String getProductName(HtmlDivision htmlProduct) {
        HtmlAnchor htmlAnchor = htmlProduct.getFirstByXPath(XPATH_OF_PRODUCT_ANCHOR);
        if (htmlAnchor == null) {
            return null;
        }

        if (htmlAnchor.getTextContent() == null) {
            return null;
        }

        return htmlAnchor.getTextContent().trim();
    }
}
