import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.Optional;
import java.util.logging.Logger;

public class SainsburysScraper {

  private final static String SAINSBURYS_URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

  private final static Logger LOG = Logger.getGlobal();
  public static void main(String[] args) {

    Optional<HtmlPage> page = SimpleHtmlPageGetter.getPageForUrl(SAINSBURYS_URL);
    if (!page.isPresent()) {
      LOG.severe("Sainsbury's page cannot be parsed. ");
      return;
    }

    HtmlPage htmlPage = page.get();
    htmlPage.getHtmlElementById("productLister").getDomElementDescendants().forEach(System.out::println);
  }
}