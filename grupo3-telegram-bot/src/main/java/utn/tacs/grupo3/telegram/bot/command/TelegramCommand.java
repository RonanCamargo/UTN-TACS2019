package utn.tacs.grupo3.telegram.bot.command;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class TelegramCommand implements IBotCommand{

	private List<String> commandParameters;
	
	protected TelegramCommand() {
		this.commandParameters = new ArrayList<String>();
	}

	@Override
	public void processMessage(AbsSender absSender, Message message, String[] arguments) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(message.getChatId());
		
		if (!validateArguments(arguments)) {
			sendMessage.setText("La cantidad de argumentos es inválida");
		} else {
			sendMessage.setText(getMessage());
		}
		
		try {
			absSender.execute(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}		
	}
	
	public void addParameter(String parameterName) {
		this.commandParameters.add(parameterName);
	}
	
	protected abstract String getMessage();
	
	
	private boolean validateArguments(String[] arguments) {
		return commandParameters.size() == arguments.length;
	}

}
