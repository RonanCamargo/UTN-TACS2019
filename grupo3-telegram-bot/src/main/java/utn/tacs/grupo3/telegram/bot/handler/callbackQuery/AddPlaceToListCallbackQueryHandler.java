package utn.tacs.grupo3.telegram.bot.handler.callbackQuery;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.handler.CallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.request.ApiRequestImpl;
import utn.tacs.grupo3.telegram.bot.user.LoggedUsers;

public class AddPlaceToListCallbackQueryHandler implements CallbackQueryHandler{

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(CallbackQuery callbackQuery) {
		String placeId = callbackQuery.getData().split("_")[1];
		SendMessage answer = new SendMessage()
				.setChatId("762715463")
				.setText("Select a list to add a new place");
		
		InlineKeyboardMarkup kb = new InlineKeyboardMarkup();
		List<String> listNames = new ApiRequestImpl().listNames(LoggedUsers.getUsername(callbackQuery.getFrom().getId()));
		List<List<InlineKeyboardButton>> buttons = listNames.stream()
				.map(listName -> 
					List.of(new InlineKeyboardButton(listName).setCallbackData(PlacesBotConstants.ADD_PLACE_TO_SELECTED_LIST + "_" + listName + "_" + placeId)))
				.collect(Collectors.toList());
		
//		InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
//		List<List<InlineKeyboardButton>> buttons = List.of(
//				List.of(new InlineKeyboardButton("Universidades").setCallbackData("/addplacetoselectedlist_" + "1")),
//				List.of(new InlineKeyboardButton("Comida").setCallbackData("/addplacetoselectedlist_" + "2"))
//				);		
		kb.setKeyboard(buttons);
		answer.setReplyMarkup(kb);
		
		return List.of(answer);
	}

}
