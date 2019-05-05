package utn.tacs.grupo3.telegram.bot.factory;

import java.util.List;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import utn.tacs.grupo3.telegram.bot.request.entity.Venue;

public final class InlineKeyboardFactory {

	private InlineKeyboardFactory() {}
	
	public static InlineKeyboardMarkup createSearchKeyboard() {
		InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
		
		List<List<InlineKeyboardButton>> buttons = List.of();		
		
		keyboard.setKeyboard(buttons);
		return keyboard;
	}
	
	public static InlineKeyboardMarkup createAddPlaceToListKeyboard(Venue venue) {
		return createInlineKeyboard(List.of(
				new InlineKeyboardButton("Add to list").setCallbackData("/addplacetolist_" + venue.getId()))
				);
	}
	
	@SafeVarargs
	public static InlineKeyboardMarkup createInlineKeyboard(List<InlineKeyboardButton>... buttonRows) {
		InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();		
		keyboard.setKeyboard(List.of(buttonRows));
		return keyboard;
	}

	
}
