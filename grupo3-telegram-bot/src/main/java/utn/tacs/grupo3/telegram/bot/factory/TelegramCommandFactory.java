package utn.tacs.grupo3.telegram.bot.factory;

import utn.tacs.grupo3.telegram.bot.command.ListsOfPlacesCommand;
import utn.tacs.grupo3.telegram.bot.command.ViewListOfPlacesCommand;
import utn.tacs.grupo3.telegram.bot.request.ApiRequestImpl;

public class TelegramCommandFactory {
	
	public static ViewListOfPlacesCommand viewListOfPlacesCommand() {
		ViewListOfPlacesCommand command = new ViewListOfPlacesCommand(new ApiRequestImpl());
		
		command.addParameter("user");
		command.addParameter("listName");		
		
		return command;
	}
	
	public static ListsOfPlacesCommand listsOfPlacesCommand() {
		ListsOfPlacesCommand command = new ListsOfPlacesCommand();
		
		command.addParameter("user");
		
		return command;
	}

}
