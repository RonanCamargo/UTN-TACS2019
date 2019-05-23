package utn.tacs.grupo3.telegram.bot.exception;

public class LocationNotEnabledException extends TelegramBotException{

	private static final long serialVersionUID = 1400003889741429765L;
	
	public LocationNotEnabledException(String message) {
		super(message);
	}

}
