package exceptions;

public class NotPlayersTurnException extends Exception {
    public NotPlayersTurnException(String message) {
        super(message);
    }
}
