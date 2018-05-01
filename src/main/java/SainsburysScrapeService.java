import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.List;
import java.util.Optional;

public interface SainsburysScrapeService {

    List<Product> buildProductsFromProductPage(HtmlPage htmlPage, String xPath);

    Optional<HtmlPage> getPageForUrl(String url);
}
