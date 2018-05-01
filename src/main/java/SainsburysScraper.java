import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class SainsburysScraper {

  private static final Logger LOGGER = Logger.getGlobal();
  private final static String SAINSBURYS_URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
  private static final String XPATH_EXPR_FOR_PRODUCTS = "//ul[contains(@class, 'productLister gridView')]/li[contains(@class, gridItem)]/div[contains(@class, 'product')]";

  public static void main(String[] args) {

    ProductHtmlParser productHtmlParser = new ProductHtmlParser();
    SainsburysScrapeService sainsburysScrapeService = new SainsburysScrapeServiceImpl(productHtmlParser);

    Optional<HtmlPage> page = sainsburysScrapeService.getPageForUrl(SAINSBURYS_URL);
    if (!page.isPresent()) {
      LOGGER.severe("Sainsbury's page cannot be parsed. ");
      return;
    }
    HtmlPage htmlPage = page.get();
    List<Product> productList = sainsburysScrapeService
        .buildProductsFromProductPage(htmlPage, XPATH_EXPR_FOR_PRODUCTS);
  }
}