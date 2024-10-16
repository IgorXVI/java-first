import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String inputPath = "C:\\Users\\inazu\\Projects\\ws-intellij\\java-first\\src\\input.csv";

        ArrayList<String> inputLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line = br.readLine();
            while (line != null) {
                inputLines.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ArrayList<Product> products = new ArrayList<>();

        for (String inputLine : inputLines) {
            String[] splitLine = inputLine.split(",");
            String productName = splitLine[0];
            double price = Double.parseDouble(splitLine[1]);
            int quantity = Integer.parseInt(splitLine[2]);
            Product product = new Product(productName, price, quantity);
            products.add(product);
        }

        StringBuilder sb = new StringBuilder();

        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }

        String outputLines = sb.toString();

        File inputFile = new File(inputPath);

        File outDir = new File(inputFile.getParent() + File.separator + "out");
        outDir.mkdir();

        String outputPath = inputFile.getParent() + "\\out\\summary.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            bw.write(outputLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
