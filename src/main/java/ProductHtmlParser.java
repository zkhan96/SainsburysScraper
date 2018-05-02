import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import java.util.Optional;

public interface ProductHtmlParser {
  Optional<Product> buildProduct(HtmlDivision htmlProduct);

}
