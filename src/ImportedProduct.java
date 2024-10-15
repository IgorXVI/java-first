public class ImportedProduct extends Product {
    private final double customsFee;

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    private double totalPrice() {
        return price + customsFee;
    }

    @Override
    public String priceTag() {
        return String.format("%s $ %.2f (Customs fee: $ %.2f)", name, totalPrice(), customsFee);
    }
}
