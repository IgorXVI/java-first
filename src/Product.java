public class Product {
    protected final String name;
    protected final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String priceTag() {
        return String.format("%s $ %.2f", name, price);
    }
}
