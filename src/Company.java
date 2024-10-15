public class Company extends TaxPayer {
    private final int numberOfEmployees;

    public Company(String name, double annualIncome, int numberOfEmployees) {
        this.name = name;
        this.annualIncome = annualIncome;
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double calculateTax() {
        double tax;
        if (numberOfEmployees > 10) {
            tax = annualIncome * 0.14;
        } else {
            tax = annualIncome * 0.16;
        }

        return tax;
    }
}
