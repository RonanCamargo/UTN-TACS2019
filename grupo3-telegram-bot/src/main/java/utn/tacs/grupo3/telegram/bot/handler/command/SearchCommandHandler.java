package utn.tacs.grupo3.telegram.bot.handler.command;

import java.io.Serializable;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import utn.tacs.grupo3.telegram.bot.factory.InlineKeyboardFactory;
import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.handler.CommandHandler;

public class SearchCommandHandler implements CommandHandler{

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(Message message) {

		InlineKeyboardMarkup keyboard = InlineKeyboardFactory.createInlineKeyboard(				
				List.of(
					new InlineKeyboardButton("Place name").setSwitchInlineQueryCurrentChat("search "),
					new InlineKeyboardButton("Near me").setSwitchInlineQueryCurrentChat("search near me")
				));
		
		SendMessage answer = MessageFactory.createSendMessage(message)
				.setText("Search by")
				.setReplyMarkup(keyboard);		
		
		return List.of(answer);
	}

}
