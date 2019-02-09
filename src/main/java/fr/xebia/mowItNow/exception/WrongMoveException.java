package fr.xebia.mowItNow.exception;

public class WrongMoveException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WrongMoveException(final String errorMessage) {
		super(errorMessage);
	}
}
