package help;

public class InvalidCharacterDataException extends RuntimeException {
    private final String customMessage;

    public InvalidCharacterDataException(String message) {
        super(message);
        this.customMessage = message;
    }

    @Override
    public String getMessage() {
        return "CharacterDataException: " + customMessage;
    }
}
