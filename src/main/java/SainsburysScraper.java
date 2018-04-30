import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.Optional;

public class SainsburysScraper {

  private final static String SAINSBURYS_URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

  public static void main(String[] args) {

    Optional<HtmlPage> page = SimpleHtmlPageGetter.getPageForUrl(SAINSBURYS_URL);

    if (!page.isPresent()) {
      System.err.println("The page returned by url: {} is invalid and therefore cannot be parsed.");
    }

    HtmlPage htmlPage = page.get();
    System.out.println(htmlPage.getTitleText());
  }
}