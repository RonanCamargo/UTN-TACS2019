package utn.tacs.grupo3.telegram.bot;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.exception.TelegramBotException;
import utn.tacs.grupo3.telegram.bot.handler.CallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.CommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.InlineQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.inlineQuery.SearchByNameInlineQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.inlineQuery.SearchNearMeInlineQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.locator.CallbackQueryHandlerLocator;
import utn.tacs.grupo3.telegram.bot.handler.locator.CommandHandlerLocator;

public class PlacesBot extends TelegramLongPollingBot{
	
	private static final String BOT_USERNAME = "TACS20191CGrupo3Bot";
	private static final String BOT_TOKEN = "837736990:AAGVZ27HyFKKyc-ZCbUhgIHE7iddP6-wchY";
	
	private static Map<String, InlineQueryHandler> inlineQueries;
		
	static {		
		inlineQueries = new HashMap<String, InlineQueryHandler>();
		inlineQueries.put(PlacesBotConstants.SEARCH_NEAR_ME_INLINE, new SearchNearMeInlineQueryHandler());
		inlineQueries.put(PlacesBotConstants.SEARCH_BY_NAME, new SearchByNameInlineQueryHandler());
	}
	
	@Override
	public void onUpdateReceived(Update update) {
		List<BotApiMethod<?>> answers = null;
		
		try {			
			if (update.hasMessage() && update.getMessage().getText() != null) {
				CommandHandler handler = CommandHandlerLocator.getHandler(update.getMessage());
				answers = handler.handle(update.getMessage());
			}
			if (update.hasCallbackQuery()) {
				CallbackQueryHandler handler = CallbackQueryHandlerLocator.getHandler(update.getCallbackQuery());
				answers = handler.handle(update.getCallbackQuery());
			}
			if (update.hasInlineQuery()) {
				String inlineQuery = getInlineQueryCommand(update.getInlineQuery().getQuery());
				if (inlineQueries.containsKey(inlineQuery)) {
					InlineQueryHandler handler = inlineQueries.get(inlineQuery);
					answers = handler.handle(update.getInlineQuery());
				}
			}
						
		} catch (TelegramBotException e) {
			e.printStackTrace();
			this.handleException(e);
		} finally {
			this.sendAnswers(answers);
		}
	}
	@Override
	public String getBotUsername() {
		return BOT_USERNAME;
	}
	@Override
	public String getBotToken() {
		return BOT_TOKEN;
	}
	
	private List<BotApiMethod<Serializable>> handleException(Exception e){
		return null;
	}
	
	private void sendAnswers(List<BotApiMethod<?>> answers) {
		if (answers != null) {
			answers.forEach(answer -> {
				try {
					execute(answer);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			});
		}
		
	}
	
	private String getInlineQueryCommand(String query) {
		if (query.startsWith(PlacesBotConstants.SEARCH_BY_NAME)) {
			return PlacesBotConstants.SEARCH_BY_NAME;
		} else if (query.startsWith(PlacesBotConstants.SEARCH_NEAR_ME_INLINE)) {
			return PlacesBotConstants.SEARCH_BY_NAME;
		}
		return "";
	}
	
	
}
