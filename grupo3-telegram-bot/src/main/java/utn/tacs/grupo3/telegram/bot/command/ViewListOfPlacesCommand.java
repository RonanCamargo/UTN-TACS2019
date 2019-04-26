package utn.tacs.grupo3.telegram.bot.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class ViewListOfPlacesCommand implements IBotCommand{

	@Override
	public String getCommandIdentifier() {
		return "view";
	}

	@Override
	public String getDescription() {
		return "View a list of places";
	}

	@Override
	public void processMessage(AbsSender absSender, Message message, String[] arguments) {
		// TODO Auto-generated method stub
		
	}

}
