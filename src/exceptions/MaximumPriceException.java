package exceptions;

public class NMaximumPriceException extends Exception{

    public NegativePriceException(String message) {
        super("Price can not be less than minimum.");
    }
}
