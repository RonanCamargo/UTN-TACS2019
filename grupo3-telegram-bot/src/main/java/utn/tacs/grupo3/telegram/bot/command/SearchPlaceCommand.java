package utn.tacs.grupo3.telegram.bot.command;

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
	protected String getMessage() {
		return "A place";
	}

}
