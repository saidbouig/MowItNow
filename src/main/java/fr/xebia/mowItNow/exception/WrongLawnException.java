package fr.xebia.mowItNow.exception;

public class WrongLawnException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WrongLawnException(final String errorMessage) {
        super(errorMessage);
    }
}