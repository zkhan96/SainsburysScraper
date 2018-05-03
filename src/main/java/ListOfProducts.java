import java.util.List;

class ListOfProducts {

    private List<Product> results;
    private double total;

    ListOfProducts(List<Product> productList) {
        this.results = productList;
        this.total = productList.stream().mapToDouble(Product::getUnitPrice).sum();
    }
}
