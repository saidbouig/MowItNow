package fr.xebia.mowItNow.exception;

public class WrongFileException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public WrongFileException(final String errorMessage) {
        super(errorMessage);
    }


}
