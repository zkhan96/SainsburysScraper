import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.Optional;

public class SimpleHtmlPageGetter {


  public static Optional<HtmlPage> getPageForUrl(String url) {
    final WebClient webClient = new WebClient(BrowserVersion.CHROME);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setCssEnabled(false);
    webClient.getOptions().setJavaScriptEnabled(false);
    HtmlPage page = null;
    try {
      page = webClient.getPage(url);
    } catch (Exception e) {
      e.getMessage();
    }
    return Optional.ofNullable(page);
  }
}
