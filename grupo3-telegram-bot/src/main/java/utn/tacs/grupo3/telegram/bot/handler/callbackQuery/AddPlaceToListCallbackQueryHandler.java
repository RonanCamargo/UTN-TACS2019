package utn.tacs.grupo3.telegram.bot.handler.callbackQuery;

import java.io.Serializable;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import utn.tacs.grupo3.telegram.bot.handler.CallbackQueryHandler;

public class AddPlaceToListCallbackQueryHandler implements CallbackQueryHandler{

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(CallbackQuery callbackQuery) {
		String placeId = callbackQuery.getData().split("_")[1];
		SendMessage answer = new SendMessage()
				.setChatId("762715463")
				.setText("Select a list to add a new place");
		
		InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
		List<List<InlineKeyboardButton>> buttons = List.of(
				List.of(new InlineKeyboardButton("Universidades").setCallbackData("/addplacetoselectedlist_" + "1")),
				List.of(new InlineKeyboardButton("Comida").setCallbackData("/addplacetoselectedlist_" + "2"))
				);		
		keyboard.setKeyboard(buttons);
		answer.setReplyMarkup(keyboard);
		
		return List.of(answer);
	}

}
