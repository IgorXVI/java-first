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

            int n = Integer.parseInt(inputLines.get(0));
            ArrayList<Product> products = new ArrayList<>();

            String productType;
            int nextLine = 1;
            for (int i = 0; i < n; i++) {
                productType = inputLines.get(nextLine);
                nextLine++;
                switch (productType) {
                    case "c": {
                        String name = inputLines.get(nextLine);
                        double price = Double.parseDouble(inputLines.get(nextLine + 1));
                        nextLine += 2;
                        products.add(new Product(name, price));
                        break;
                    }
                    case "i": {
                        String name = inputLines.get(nextLine);
                        double price = Double.parseDouble(inputLines.get(nextLine + 1));
                        double customsFee = Double.parseDouble(inputLines.get(nextLine + 2));
                        nextLine += 3;
                        products.add(new ImportedProduct(name, price, customsFee));
                        break;
                    }
                    case "u": {
                        String name = inputLines.get(nextLine);
                        double price = Double.parseDouble(inputLines.get(nextLine + 1));
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = sdf.parse(inputLines.get(nextLine + 2));
                        nextLine += 3;
                        products.add(new UsedProduct(name, price, date));
                        break;
                    }
                }
            }

            for (Product product : products) {
                System.out.println(product.priceTag());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ParseException e) {
            System.out.println("Date format exception");
        }
    }
}
