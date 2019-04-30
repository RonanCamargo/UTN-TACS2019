package utn.tacs.grupo3.telegram.bot.command;

import org.telegram.telegrambots.meta.api.objects.Message;

public class SearchPlaceCommand extends TelegramCommand{

	public SearchPlaceCommand() {
		super();
	}
	
	@Override
	public String getCommandIdentifier() {
		return "search";
	}

	@Override
	public String getDescription() {
		return "Search a place";
	}

	@Override
	protected String getResponseMessage(Message message, String[] arguments) {
		return "A place";
	}

}
