import java.util.List;

class JSONOutput {

    private List<Product> results;
    private double total;

    JSONOutput(List<Product> productList) {
        this.results = productList;
        this.total = productList.stream().mapToDouble(Product::getUnitPrice).sum();
    }
}
