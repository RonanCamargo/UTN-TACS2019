package utn.tacs.grupo3.telegram.bot.exception;

public class CallbackQueryNotFoundException extends TelegramBotException{

	private static final long serialVersionUID = 4259632819916437932L;
	
	public CallbackQueryNotFoundException(String message) {
		super(message);
	}

}
