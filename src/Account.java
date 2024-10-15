public class Account {
    private final int id;
    private final String name;
    private double balance;
    private final double limit;

    public Account(int id, String name, double balance, double limit) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.limit = limit;
    }

    public void withdraw(double amount) throws WithdrawError {
        if (amount > limit) {
            throw new WithdrawError("The amount exceeds withdraw limit");
        }

        if (amount > balance) {
            throw new WithdrawError("Not enough balance");
        }

        balance -= amount;
    }

    public String toString() {
        return String.format("ID: %d, Name: %s, Balance: %.2f", id, name, balance);
    }
}
