import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private final Date moment;
    private final OrderStatus status;
    private final List<OrderItem> items;
    private final Client user;

    public Order(Date moment, OrderStatus status, Client user) {
        this.moment = moment;
        this.status = status;
        this.user = user;
        this.items = new ArrayList<OrderItem>();
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public void remoteItem(OrderItem item) {
        this.items.remove(item);
    }

    public double total() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.subTotal();
        }
        return total;
    }

    public String toString() {
        SimpleDateFormat dateFormatMoment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat dateFormatBirth = new SimpleDateFormat("dd/MM/yyyy");

        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:\n")
                .append(String.format("Order moment: %s\n", dateFormatMoment.format(moment)))
                .append(String.format("Order status: %s\n", status.toString()))
                .append(
                        String.format("Client: %s (%s) - %s\n",
                                user.getName(),
                                dateFormatBirth.format(user.getBirthDate()),
                                user.getEmail()
                        )
                )
                .append("Order items:\n");

        for (OrderItem item : items) {
            sb.append(
                    String.format("%s, $%.2f, Quantity: %d, Subtotal: $%.2f\n",
                            item.getProductName(),
                            item.getProductPrice(),
                            item.getQuantity(),
                            item.subTotal()
                    )
            );
        }

        sb.append(String.format("Total price: $%.2f\n", this.total()));

        return sb.toString();
    }
}
