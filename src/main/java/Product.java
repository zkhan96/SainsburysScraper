public class Product {

    private final String title;
    private final Integer kcal_per_100g;
    private final double unit_price;
    private final String description;

    Product(String title, Integer kcal_per_100g, double unit_price, String description) {
        this.title = title;
        this.kcal_per_100g = kcal_per_100g > 0 ? kcal_per_100g : null;
        this.unit_price = unit_price;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getkCalPer100g() {
        return kcal_per_100g;
    }

    public double getUnitPrice() {
        return unit_price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
            "title='" + title + '\'' +
            ", kcal_per_100g='" + kcal_per_100g + '\'' +
            ", unit_price='" + unit_price + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
