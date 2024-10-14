public class OrderItem {
    private final int quantity;
    private final Product product;

    public OrderItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    double subTotal() {
        return this.product.getPrice() * this.quantity;
    }

    String getProductName() {
        return this.product.getName();
    }

    double getProductPrice() {
        return this.product.getPrice();
    }

    int getQuantity() {
        return this.quantity;
    }
}
