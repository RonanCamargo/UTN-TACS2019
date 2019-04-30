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

	protected abstract String getResponseMessage(Message message, String[] arguments);
//	protected abstract ReplyKeyboard getKeyboard(Message message);
	
	@Override
	public void processMessage(AbsSender absSender, Message message, String[] arguments) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(message.getChatId());
		sendMessage.setText(validateArgumentsAndSetText(message, arguments));
		sendMessage.enableHtml(true);
		
		try {
			absSender.execute(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}		
	}
	
	public void addParameter(String parameterName) {
		this.commandParameters.add(parameterName);
	}
	
	
	private String validateArgumentsAndSetText(Message message, String[] arguments) {
		if (commandParameters.size() == arguments.length) {
			return getResponseMessage(message, arguments);
		}else {
			return "La cantidad de argumentos es inválida";
		}
	}
}
