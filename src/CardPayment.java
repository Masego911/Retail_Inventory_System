import javax.smartcardio.Card;

public class CardPayment implements Payment{


    @Override
    public void processPayment(double amount) {
        String formatted = CurrencyFormatter.format(amount);

        System.out.println("Card payment of " + formatted + " processed");
    }
}
