package utn.tacs.grupo3.telegram.bot.command;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.util.TelegramCommandUtil;

public class CommandListCommand extends TelegramCommand{

	private TelegramLongPollingCommandBot bot;
	
	public CommandListCommand(TelegramLongPollingCommandBot bot) {
		super();
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
	protected String getResponseMessage(Message message, String[] arguments) {
		return TelegramCommandUtil.formattedCommandList(bot.getRegisteredCommands());	
	}
}
