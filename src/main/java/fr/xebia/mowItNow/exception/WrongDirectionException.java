package fr.xebia.mowItNow.exception;

public class WrongDirectionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WrongDirectionException(final String errorMessage) {
        super(errorMessage);
    }
}