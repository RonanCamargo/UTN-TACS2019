package utn.tacs.grupo3.telegram.bot.handler.command;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.factory.InlineKeyboardFactory;
import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.handler.AbstractCommandHandler;

/**
 * Handler for /search command
 */
public class SearchCommandHandler extends AbstractCommandHandler{

	@Override
	public List<BotApiMethod<?>> handle(Message message) {
		
		InlineKeyboardMarkup keyboard = InlineKeyboardFactory.createInlineKeyboard(				
				List.of(
					new InlineKeyboardButton("By name").setSwitchInlineQueryCurrentChat(PlacesBotConstants.SEARCH_BY_NAME),
					new InlineKeyboardButton("Near me").setSwitchInlineQueryCurrentChat(PlacesBotConstants.SEARCH_NEAR_ME_INLINE)
				));
		
		SendMessage answer = MessageFactory.createSendMessage(message)
				.setText("Search places")
				.setReplyMarkup(keyboard);		
		
		return List.of(answer);
	}

}
