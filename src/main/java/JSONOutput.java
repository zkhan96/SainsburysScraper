import java.util.List;

public class JSONOutput {

    private List<Product> results;
    private double total;

    public JSONOutput(List<Product> productList) {
        this.results = productList;
        this.total = productList.size();
    }
}
