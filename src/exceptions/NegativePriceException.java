package exceptions;

public class negativePriceException extends Exception{

    public negativePriceException(String message) {
        super("Price can not be negative.");
    }
}
