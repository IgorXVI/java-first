import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
            ArrayList<TaxPayer> taxPayers = new ArrayList<>();

            String taxPayerType;
            int nextLine = 1;
            for (int i = 0; i < n; i++) {
                taxPayerType = inputLines.get(nextLine);
                String name = inputLines.get(nextLine + 1);
                double annualIncome = Double.parseDouble(inputLines.get(nextLine + 2));
                nextLine += 3;

                switch (taxPayerType) {
                    case "i": {
                        double healthExpenditure = Double.parseDouble(inputLines.get(nextLine));
                        nextLine++;

                        taxPayers.add(new Person(name, annualIncome, healthExpenditure));

                        break;
                    }
                    case "c": {
                        int numberOfEmployees = Integer.parseInt(inputLines.get(nextLine));
                        nextLine++;

                        taxPayers.add(new Company(name, annualIncome, numberOfEmployees));

                        break;
                    }
                }
            }

            double totalTaxes = 0;
            System.out.println("TAXES PAID:");
            for (TaxPayer taxPayer : taxPayers) {
                double tax = taxPayer.calculateTax();
                totalTaxes += tax;
                System.out.printf("%s: $ %.2f\n", taxPayer.getName(), tax);
            }

            System.out.printf("\nTOTAL TAXES: $ %.2f\n", totalTaxes);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
