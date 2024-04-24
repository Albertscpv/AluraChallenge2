public class Totals {
    String baseCurrency;
    String exchangeCurrency;
    double amount;
    double total;


    public Totals(String baseCurrency, String exchangeCurrency, double amount, double total) {
        this.baseCurrency = baseCurrency;
        this.exchangeCurrency = exchangeCurrency;
        this.amount = amount;
        this.total = total;
    }
}
