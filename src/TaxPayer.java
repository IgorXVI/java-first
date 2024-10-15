public abstract class TaxPayer {
    protected String name;
    protected double annualIncome;

    public abstract double calculateTax();

    public String getName() {
        return name;
    }
}
