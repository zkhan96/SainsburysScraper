import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductHtmlParserTest {
    private ProductHtmlParser productHtmlParser;
    private final String XPATH_OF_PRODUCT_ANCHOR = "div[contains(@class, 'productInfo')]/div[contains(@class, 'productNameAndPromotions')]/h3/a";
    private final String XPATH_FOR_NUTRITIONAL_VALUE = "//table[contains(@class, 'nutritionTable')]/tbody/tr[contains(@class, 'tableRow1')]/td[contains(@class, 'tableRow1')]";
    private  final String XPATH_OF_PRODUCT_TITLE = "//div[contains(@class, 'productTitleDescriptionContainer')]/h1";


    @BeforeEach
    void setUp() {
        productHtmlParser = new ProductHtmlParser();
    }

    @Test
    void givenNullHtmlProduct_whenParsingProduct_thenReturnEmpty() {
        assertEquals( Optional.empty(), productHtmlParser.buildProduct(null));
    }

    @Test
    void givenHtmlProductWithNoTitle_whenParsingProduct_thenReturnProductWithNullTitle() {
//        given
        HtmlDivision htmlProduct = mock(HtmlDivision.class);

//        then
        assertEquals(null, productHtmlParser.buildProduct(htmlProduct).get().getTitle());
    }

    @Test
    void givenHtmlProductWithTitle_whenParsingProduct_thenReturnProductWithTitle() throws Exception {
//        given
        HtmlDivision htmlProduct = mock(HtmlDivision.class);
        HtmlAnchor htmlAnchor = mock(HtmlAnchor.class);
        HtmlPage page = mock(HtmlPage.class);
        HtmlElement titleElement = mock(HtmlElement.class);

        doReturn(htmlAnchor).when(htmlProduct).getFirstByXPath(XPATH_OF_PRODUCT_ANCHOR);
        when(htmlAnchor.click()).thenReturn(page);
        doReturn(titleElement).when(page).getFirstByXPath(XPATH_OF_PRODUCT_TITLE);
        when(titleElement.getTextContent()).thenReturn("htmlAnchorText");

//        then
        assertEquals("htmlAnchorText", productHtmlParser.buildProduct(htmlProduct).get().getTitle());
    }

}