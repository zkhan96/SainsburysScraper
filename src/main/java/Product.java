public final class Product {

    private final String title;
    private final Integer kcalPer100G;
    private final double unitPrice;
    private String description;

    Product(String title, Integer kcalPer100G, double unitPrice, String description) {
        this.title = title;
        this.kcalPer100G = kcalPer100G > 0 ? kcalPer100G : null;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getkCalPer100g() {
        return kcalPer100G;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
            "title='" + title + '\'' +
            ", kcalPer100G='" + kcalPer100G + '\'' +
            ", unitPrice='" + unitPrice + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
