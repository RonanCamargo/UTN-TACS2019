package utn.tacs.grupo3.telegram.bot.request.exception;

public class BadCredentialsException extends Exception {

	private static final long serialVersionUID = -7747235993538036556L;
	
	public BadCredentialsException(String message, Throwable e) {
		super(message, e);
	}

}
