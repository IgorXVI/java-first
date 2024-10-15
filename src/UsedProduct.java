import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
    private final Date manufactureDate;

    public UsedProduct(String name, double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%s (used) $ %.2f (Manufacture date: %s)", name, price, sdf.format(manufactureDate));
    }
}
