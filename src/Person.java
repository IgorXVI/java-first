public class Person extends TaxPayer {
    private final double healthExpenditure;

    public Person(String name, double annualIncome, double healthExpenditure) {
        this.name = name;
        this.annualIncome = annualIncome;
        this.healthExpenditure = healthExpenditure;
    }

    @Override
    public double calculateTax() {
        double tax;
        if (annualIncome < 20000.00) {
            tax = annualIncome * 0.15 - 0.5 * healthExpenditure;
        } else {
            tax = annualIncome * 0.25 - 0.5 * healthExpenditure;
        }

        if (tax < 0) {
            tax = 0;
        }

        return tax;
    }
}
