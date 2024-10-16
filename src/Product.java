public class Product {
    private final String name;
    private final double price;
    private final int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private double calcTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s,%.2f", name, calcTotal());
    }
}
