package utn.tacs.grupo3.telegram.bot.command;

import java.util.List;

import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.request.ApiRequestImpl;
import utn.tacs.grupo3.telegram.bot.util.TelegramCommandUtil;

public class ListsOfPlacesCommand extends TelegramCommand{

	@Override
	public String getCommandIdentifier() {
		return "lists";
	}

	@Override
	public String getDescription() {
		return "Lists of places";
	}

	@Override
	protected String getResponseMessage(Message message, String[] arguments) {
		List<String> listNames = new ApiRequestImpl().listsOfPlacesNames(arguments[0]);
		
		return TelegramCommandUtil.formattedListsOfPlacesList(listNames);
	}

}
