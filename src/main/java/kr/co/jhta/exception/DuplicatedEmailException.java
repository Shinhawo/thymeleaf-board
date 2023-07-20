package kr.co.jhta.exception;

public class DuplicatedEmailException extends JhtaException {

	private static final long serialVersionUID = -391884139794026693L;

	public DuplicatedEmailException(String message) {
		super(message);
	}
}
