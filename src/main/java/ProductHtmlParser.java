import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.Optional;

class ProductHtmlParser {

    private final String XPATH_OF_PRODUCT_ANCHOR = "div[contains(@class, 'productInfo')]/div[contains(@class, 'productNameAndPromotions')]/h3/a";
    private final String XPATH_OF_PRODUCT_TITLE = "//div[contains(@class, 'productTitleDescriptionContainer')]/h1";
    private final String XPATH_FOR_NUTRITIONAL_VALUE = "//table[contains(@class, 'nutritionTable')]/tbody/tr[contains(@class, 'tableRow1')]/td[contains(@class, 'tableRow1')]";
    private final String XPATH_FOR_PRODUCT_PRICE ="//p[contains(@class, 'pricePerUnit')]";
    private final String XPATH_FOR_PRODUCT_DESCRIPTION ="//div[contains(@class, 'productText')]/p";


    Optional<Product> buildProduct(HtmlDivision htmlProduct) {
        return htmlProduct != null
            ? Optional.of(new Product(
            getDataFromAnchorByXPath(htmlProduct.getFirstByXPath(XPATH_OF_PRODUCT_ANCHOR), XPATH_OF_PRODUCT_TITLE),
            getDataFromAnchorByXPath(htmlProduct.getFirstByXPath(XPATH_OF_PRODUCT_ANCHOR), XPATH_FOR_NUTRITIONAL_VALUE),
            getDataFromAnchorByXPath(htmlProduct.getFirstByXPath(XPATH_OF_PRODUCT_ANCHOR), XPATH_FOR_PRODUCT_PRICE),
            getDataFromAnchorByXPath(htmlProduct.getFirstByXPath(XPATH_OF_PRODUCT_ANCHOR), XPATH_FOR_PRODUCT_DESCRIPTION)))
            : Optional.empty();
    }


    private String getDataFromAnchorByXPath(HtmlAnchor productAnchor, String xPath) {
        if (productAnchor == null) {
            return null;
        }

        HtmlPage productPage;
        try {
            productPage = productAnchor.click();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if (productPage == null) {
            return null;
        }

        HtmlElement htmlElement = productPage.getFirstByXPath(xPath);
        return htmlElement != null ? htmlElement.getTextContent().trim() : null;
    }
}
