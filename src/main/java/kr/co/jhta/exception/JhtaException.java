package kr.co.jhta.exception;

public class JhtaException extends RuntimeException{

	private static final long serialVersionUID = 6358721302834790336L;

	public JhtaException(String message) {
		super(message);
	}
	
	public JhtaException(String message, Throwable cause) {
		super(message, cause);
	}
}
