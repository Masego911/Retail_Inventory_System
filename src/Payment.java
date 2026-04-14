import java.text.NumberFormat;
import java.util.Locale;

public interface Payment {

    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "ZA"));
    public void processPayment(double amount);
}
