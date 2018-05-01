import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SainsburysScrapeServiceImplTest {

  private final String SAINSBURYS_URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

  private SainsburysScrapeService sainsburysScrapeService;

  @BeforeEach
  void setUp() {
    ProductHtmlParser productHtmlParser = new ProductHtmlParser();
    sainsburysScrapeService = new SainsburysScrapeServiceImpl(productHtmlParser);
  }


  @Test
  void givenValidUrl_whenParsingHtml_thenReturnOptionalOfNonEmptyHtmlPage() {
//    when
    Optional<HtmlPage> page = sainsburysScrapeService.getPageForUrl(SAINSBURYS_URL);

//    then
    assertTrue(page.isPresent());
  }

  @Test
  void givenInvalidUrl_whenParsingHtml_thenReturnOptionalOfNonEmptyHtmlPage() {
//    when
    Optional<HtmlPage> page = sainsburysScrapeService.getPageForUrl("zohaib.co.uk");

//    then
    assertFalse(page.isPresent());
  }


  @Test
  void givenNullHtmlPage_whenBuildingProductsFromProductPage_thenReturnEmptyList() {
//    when
    List<Product> productList = sainsburysScrapeService
        .buildProductsFromProductPage(null, "xpath");

//    then
    assertTrue(productList.isEmpty());
  }

  @Test
  void givenNullXPath_whenBuildingProductsFromProductPage_thenReturnEmptyList() {
//    given
    HtmlPage htmlPage = mock(HtmlPage.class);

//    when
    List<Product> productList = sainsburysScrapeService
        .buildProductsFromProductPage(htmlPage,null);

//    then
    assertTrue(productList.isEmpty());
  }

  @Test
  void givenEmptyXPath_whenBuildingProductsFromProductPage_thenReturnEmptyList() {
//    given
    HtmlPage htmlPage = mock(HtmlPage.class);

//    when
    List<Product> productList = sainsburysScrapeService
        .buildProductsFromProductPage(htmlPage,"");

//    then
    assertTrue(productList.isEmpty());
  }

  @Test
  void givenInvalidXPath_whenBuildingProductsFromProductPage_thenReturnEmptyList() {
//    given
    HtmlPage htmlPage = mock(HtmlPage.class);

//    when
    List<Product> productList = sainsburysScrapeService
        .buildProductsFromProductPage(htmlPage,"blah");

//    then
    assertTrue(productList.isEmpty());
  }

  @Test
  void givenValidXPath_andValidHtmlPage_whenBuildingProductsFromProductPage_thenReturnProductList() {
//    given
    ProductHtmlParser productHtmlParser = mock(ProductHtmlParser.class);
    sainsburysScrapeService = new SainsburysScrapeServiceImpl(productHtmlParser);
    HtmlPage htmlPage = mock(HtmlPage.class);
    HtmlDivision htmlDivision = mock(HtmlDivision.class);
    Product product = new Product("hehe", "1337kJ", 13.37, "l33t product");
    doReturn(Collections.singletonList(htmlDivision)).when(htmlPage).getByXPath(anyString());
    when(productHtmlParser.buildProduct(htmlDivision)).thenReturn(Optional.of(product));

//    when
    List<Product> productList = sainsburysScrapeService
        .buildProductsFromProductPage(htmlPage, "blah");

//    then
    assertFalse(productList.isEmpty());
  }

}