import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductHtmlParserTest {
    private ProductHtmlParser productHtmlParser;

    @BeforeEach
    void setUp() {
        productHtmlParser = new ProductHtmlParser();
    }

    @Test
    void givenNullHtmlProduct_whenParsingProduct_thenReturnEmpty() {
        assertEquals(productHtmlParser.buildProduct(null), Optional.empty());
    }

    @Test
    void givenHtmlProduct_whenParsingProduct_thenReturnProduct() {

    }

}