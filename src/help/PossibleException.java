package help;

public class PossibleException extends Exception {
    private String customMessage;
    public PossibleException(String message) {
        super(message);
        this.customMessage = message;
    }
    @Override
    public String getMessage() {
        return "BuyException: " + customMessage;
    }
}
