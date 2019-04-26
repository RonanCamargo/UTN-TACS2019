package utn.tacs.grupo3.telegram.bot.command;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import utn.tacs.grupo3.telegram.bot.util.TelegramCommandUtil;

public class CommandListCommand implements IBotCommand{

	private TelegramLongPollingCommandBot bot;
	
	public CommandListCommand(TelegramLongPollingCommandBot bot) {
		this.bot = bot; 
	}
	
	@Override
	public String getCommandIdentifier() {
		return "commands";
	}

	@Override
	public String getDescription() {
		return "List available commands";
	}

	@Override
	public void processMessage(AbsSender absSender, Message message, String[] arguments) {
		SendMessage sendMessage = new SendMessage(
				message.getChatId(), 
				TelegramCommandUtil.formattedCommandList(bot.getRegisteredCommands()));
		
		try {
			absSender.execute(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
