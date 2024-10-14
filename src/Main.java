import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try {
            File myObj = new File("src/input.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> inputLines = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                inputLines.add(data);
            }
            myReader.close();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date clientBirth = sdf.parse(inputLines.get(2));
            Client user = new Client(inputLines.get(0), inputLines.get(1), clientBirth);

            OrderStatus orderStatus = OrderStatus.valueOf(inputLines.get(3));
            Order order = new Order(new Date(), orderStatus, user);

            int itemCount = Integer.parseInt(inputLines.get(4));

            for (int i = 0; i < itemCount; i++) {
                String itemName = inputLines.get(5 + i * 3);
                double itemPrice = Double.parseDouble(inputLines.get(6 + i * 3));

                Product product = new Product(itemName, itemPrice);

                int quantity = Integer.parseInt(inputLines.get(7 + i * 3));

                OrderItem item = new OrderItem(quantity, product);
                order.addItem(item);
            }

            System.out.print(order);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ParseException e) {
            System.out.println("Cannot parse date");
        }
    }
}
