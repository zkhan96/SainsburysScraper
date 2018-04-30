import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class SimpleHtmlPageGetterTest {
  private final String SAINSBURYS_URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

  @Test
  void givenValidUrl_whenParsingHtml_thenReturnOptionalOfNonEmptyHtmlPage() {
//    when
    Optional<HtmlPage> page = SimpleHtmlPageGetter.getPageForUrl(SAINSBURYS_URL);

//    then
    assertTrue(page.isPresent());
  }

  @Test
  void givenInvalidUrl_whenParsingHtml_thenReturnOptionalOfNonEmptyHtmlPage() {
//    when
    Optional<HtmlPage> page = SimpleHtmlPageGetter.getPageForUrl("zohaib.co.uk");

//    then
    assertFalse(page.isPresent());
  }
}