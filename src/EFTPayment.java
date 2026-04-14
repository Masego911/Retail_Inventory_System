public class EFTPayment implements Payment{

    @Override
    public void processPayment(double amount) {

        String formatted = CurrencyFormatter.format(amount);

        System.out.println("EFT payment of " + formatted + " processed");
    }
}
