package utn.tacs.grupo3.telegram.bot.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class SearchPlaceCommand implements IBotCommand{

	@Override
	public String getCommandIdentifier() {
		return "search";
	}

	@Override
	public String getDescription() {
		return "Search a place";
	}

	@Override
	public void processMessage(AbsSender absSender, Message message, String[] arguments) {
		// TODO Auto-generated method stub
		
	}

}
