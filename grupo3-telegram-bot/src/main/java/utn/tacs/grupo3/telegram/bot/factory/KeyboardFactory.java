package utn.tacs.grupo3.telegram.bot.factory;

import java.util.Arrays;
import java.util.List;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

public class KeyboardFactory {

	public static ReplyKeyboard removeKeyboard() {
	    ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
	    replyKeyboardRemove.setSelective(true);
	    
	    return replyKeyboardRemove;
	}
	
	public static ReplyKeyboard acceptOrCancelKeyboard() {
		ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
		
		KeyboardRow accept = new KeyboardRow();
		accept.add(new KeyboardButton("Accept"));
		KeyboardRow cancel = new KeyboardRow();
		cancel.add(new KeyboardButton("Cancel"));
		List<KeyboardRow> rows = Arrays.asList(accept, cancel);
		
		keyboard.setKeyboard(rows);
		
		return keyboard;
	}
}
