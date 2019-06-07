package utn.tacs.grupo3.repository.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5801772537829830840L;

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}
}
