package utn.tacs.grupo3.telegram.bot.factory;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;

public final class ReplyKeyboardFactory {
	
	private ReplyKeyboardFactory() {}
	
	public static ReplyKeyboardMarkup createInitialKeyBoard() {
		return createKeyboard(List.of(PlacesBotConstants.HELP_COMMAND));
	}
	
	public static ReplyKeyboardMarkup createCommandKeyboard() {
		return createKeyboard(
				List.of(PlacesBotConstants.MY_LISTS_COMMAND, PlacesBotConstants.SEARCH_COMMAND),
				List.of(PlacesBotConstants.LOGOUT_COMMAND)
				);		
	}
	
	public static ReplyKeyboardRemove createKeyboardRemove() {
		return new ReplyKeyboardRemove().setSelective(true);
	}

	@SafeVarargs
	private static ReplyKeyboardMarkup createKeyboard(List<String>...lists) {
		ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
		
		List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>(lists.length);
		
		List.of(lists).forEach(aList -> {
			KeyboardRow row = new KeyboardRow();
			aList.forEach(anElement -> row.add(new KeyboardButton(anElement)));
			keyboardRows.add(row);
		} );		
		
		keyboard.setKeyboard(keyboardRows);
		keyboard.setSelective(true);
		keyboard.setResizeKeyboard(true);
		
		return keyboard;
	}
	

}
