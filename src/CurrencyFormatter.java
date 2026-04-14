import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    public static String format(double amt)
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "ZA"));
        return nf.format(amt);
    }
}
