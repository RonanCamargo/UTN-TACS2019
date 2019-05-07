package utn.tacs.grupo3.telegram.bot.exception;

public class CommandNotFoundException extends TelegramBotException{

	private static final long serialVersionUID = 6701939790129118565L;
	
	public CommandNotFoundException(String message) {
		super(message);
	}

}
