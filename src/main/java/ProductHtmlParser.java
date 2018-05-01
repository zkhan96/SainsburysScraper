import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableDataCell;
import java.util.List;

class ProductHtmlParser {

    private  final String XPATH_OF_PRODUCT_ANCHOR = "div[contains(@class, 'productInfo')]/div[contains(@class, 'productNameAndPromotions')]/h3/a";
    private  final String XPATH_FOR_NUTRITIONAL_VALUE = "//table[contains(@class, 'nutritionTable')]/tbody/tr[contains(@class, 'tableRow1')]/td[contains(@class, 'tableRow1')]";


    Product buildProduct(HtmlDivision htmlProduct) {
        return new Product(getProductName(htmlProduct), getkCalPer100g(htmlProduct), 0.0, "");
    }

    private String getkCalPer100g(HtmlDivision htmlProduct) {
        HtmlPage productPage;
        try {
            productPage = ((HtmlAnchor) htmlProduct.getByXPath(XPATH_OF_PRODUCT_ANCHOR).get(0)).click();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        HtmlTableDataCell energyTableCell = productPage.getFirstByXPath(XPATH_FOR_NUTRITIONAL_VALUE);
        return energyTableCell != null ? energyTableCell.getTextContent() : null;
    }

    private String getProductName(HtmlDivision htmlProduct) {
        List<?> htmlAnchorList = htmlProduct.getByXPath(XPATH_OF_PRODUCT_ANCHOR);
        if (htmlAnchorList.isEmpty()) {
            return null;
        }

        HtmlAnchor htmlAnchor = (HtmlAnchor) htmlAnchorList.get(0);

        if (htmlAnchor.getTextContent() == null) {
            return null;
        }

        return htmlAnchor.getTextContent().trim();
    }
}
