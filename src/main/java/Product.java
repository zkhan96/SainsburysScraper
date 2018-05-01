public class Product {

    private final String title;
    private final String kCalPer100g;
    private final double unitPrice;
    private final String description;

    public Product(String title, String kCalPer100g, double unitPrice, String description) {

        this.title = title;
        this.kCalPer100g = kCalPer100g;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getkCalPer100g() {
        return kCalPer100g;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
            "title='" + title + '\'' +
            ", kCalPer100g=" + kCalPer100g +
            ", unitPrice=" + unitPrice +
            ", description='" + description + '\'' +
            '}';
    }
}