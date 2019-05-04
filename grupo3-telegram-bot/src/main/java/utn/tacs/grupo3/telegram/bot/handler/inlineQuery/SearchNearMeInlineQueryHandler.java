package utn.tacs.grupo3.telegram.bot.handler.inlineQuery;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultLocation;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultVenue;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import utn.tacs.grupo3.telegram.bot.factory.InlineKeyboardFactory;
import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.handler.InlineQueryHandler;

public class SearchNearMeInlineQueryHandler implements InlineQueryHandler{

	@Override
	public List<BotApiMethod<?>> handleInlineQuery(InlineQuery inlineQuery) {
		AnswerInlineQuery answer = MessageFactory.createAnswerInlineQuery(inlineQuery);
		Location location = inlineQuery.getLocation();
		location.getClass();
		
		InlineKeyboardMarkup keyboard = InlineKeyboardFactory.createInlineKeyboard(
				List.of(new InlineKeyboardButton("Add to list").setCallbackData("/addplacetolist_" + "1"))
				);
		
		List<InlineQueryResult> results = List.of(
				new InlineQueryResultLocation().setId("1").setTitle("UTN Campus")
					.setLatitude(-34.659606f).setLongitude(-58.468083f).setReplyMarkup(keyboard),
				new InlineQueryResultLocation().setId("2").setTitle("UTN Medrano")
					.setLatitude(-34.598359f).setLongitude(-58.419878f).setReplyMarkup(keyboard)
				);
		answer.setResults(results);		

		return List.of(answer);
	}

}
