import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class SainsburysScraper {

  private static final Logger LOGGER = Logger.getGlobal();
  private static final String SAINSBURYS_URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
//  private static final String REAL_SAINSBURYS_URL = "https://www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants#langId=44&storeId=10151&catalogId=10123&categoryId=12563&parent_category_rn=&top_category=12563&pageSize=36&orderBy=FAVOURITES_ONLY%7CTOP_SELLERS&searchTerm=&beginIndex=0";
  private static final String XPATH_EXPR_FOR_PRODUCTS = "//ul[contains(@class, 'productLister gridView')]/li[contains(@class, gridItem)]/div[contains(@class, 'product')]";

  public static void main(String[] args) {

    ProductHtmlParser productHtmlParser = new ProductHtmlParserImpl();
    SainsburysScrapeService sainsburysScrapeService = new SainsburysScrapeServiceImpl(productHtmlParser);

    Optional<HtmlPage> page = sainsburysScrapeService.getPageForUrl(SAINSBURYS_URL);
    if (!page.isPresent()) {
      LOGGER.severe("Sainsbury's page cannot be parsed. ");
      return;
    }

    List<Product> productList = sainsburysScrapeService
        .buildProductsFromProductPage(page.get(), XPATH_EXPR_FOR_PRODUCTS);

    Gson gson = new GsonBuilder().disableHtmlEscaping().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
    System.out.println(gson.toJson(new ListOfProducts(productList)));
  }
}