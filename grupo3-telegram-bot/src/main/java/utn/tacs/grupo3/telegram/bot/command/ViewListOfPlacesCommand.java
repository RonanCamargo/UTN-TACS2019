package utn.tacs.grupo3.telegram.bot.command;

import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.request.ApiRequest;

public class ViewListOfPlacesCommand extends TelegramCommand{
		
	private ApiRequest placeRequest;
	
	public ViewListOfPlacesCommand(ApiRequest placeRequest) {
		super();
		this.placeRequest = placeRequest;
	}

	@Override
	public String getCommandIdentifier() {
		return "viewlist";
	}

	@Override
	public String getDescription() {
		return "View a list of places";
	}

	@Override
	protected String getResponseMessage(Message message, String[] arguments) {
		String user = arguments[0];
		String listName = arguments[1];
		
		return placeRequest.listOfPlaces(user, listName).getBody();
	}

}
