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
            int nextLine = 1;
            for (int i = 0; i < n; i++) {
                nextLine += handleAccount(inputLines, nextLine);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static int handleAccount(ArrayList<String> inputLines, int firstLine) {
        int number = Integer.parseInt(inputLines.get(firstLine));
        String holder = inputLines.get(firstLine + 1);
        double initialBalance = Double.parseDouble(inputLines.get(firstLine + 2));
        double limit = Double.parseDouble(inputLines.get(firstLine + 3));
        double withdrawAmount = Double.parseDouble(inputLines.get(firstLine + 4));

        try {
            Account account = new Account(number, holder, initialBalance, limit);
            account.withdraw(withdrawAmount);
            System.out.println(account);
        } catch (WithdrawError e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }

        return 5;
    }
}
