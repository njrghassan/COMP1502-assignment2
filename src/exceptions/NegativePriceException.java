package exceptions;

public class NegativePriceException extends Exception{

    public NegativePriceException(String message) {
        super("Price can not be negative.");
    }
}
