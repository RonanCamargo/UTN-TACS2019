package utn.tacs.grupo3.telegram.bot.handler.callbackQuery;

import java.io.Serializable;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.handler.CallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.request.ApiRequestImpl;
import utn.tacs.grupo3.telegram.bot.user.LoggedUsers;

public class AddPlaceToSelectedListCallbackQueryHandler implements CallbackQueryHandler{

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(CallbackQuery callbackQuery) {
		String[] parsed = callbackQuery.getData().split(PlacesBotConstants.ADD_PLACE_TO_SELECTED_LIST + "_")[1].split("_");
		
		new ApiRequestImpl().addPlaceToList(
				LoggedUsers.getUsername(callbackQuery.getFrom().getId()),
				parsed[0],
				parsed[1],
				callbackQuery.getFrom().getId());
		
		SendMessage answer = MessageFactory.createSendMessage(callbackQuery.getMessage())
				.setText("Place added to list successfully");
		
		return List.of(answer);
	}

}
