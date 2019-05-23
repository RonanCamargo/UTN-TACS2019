package utn.tacs.grupo3.telegram.bot.handler.locator;

import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.exception.CallbackQueryNotFoundException;
import utn.tacs.grupo3.telegram.bot.handler.CallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.callbackQuery.AddPlaceToListCallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.callbackQuery.AddPlaceToSelectedListCallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.callbackQuery.ViewPlaceCallbackQueryHandler;

public class CallbackQueryHandlerLocator {

	private static Map<String, CallbackQueryHandler> callbackQueries;
	
	static {
		callbackQueries = new HashMap<String, CallbackQueryHandler>();
		callbackQueries.put(PlacesBotConstants.VIEW_PLACE_CALLBACK, new ViewPlaceCallbackQueryHandler());
		callbackQueries.put(PlacesBotConstants.ADD_PLACE_TO_LIST, new AddPlaceToListCallbackQueryHandler());
		callbackQueries.put(PlacesBotConstants.ADD_PLACE_TO_SELECTED_LIST, new AddPlaceToSelectedListCallbackQueryHandler());
	}
	
	public static CallbackQueryHandler getHandler(CallbackQuery callbackQuery) {
		String callbackQueryCommand = callbackQuery.getData().split("_")[0];
		
		if (!callbackQueries.containsKey(callbackQueryCommand)) {
			throw new CallbackQueryNotFoundException("CallbackQuery: " + callbackQueryCommand + " is not registered");
		}
		return callbackQueries.get(callbackQueryCommand);
	}
}
