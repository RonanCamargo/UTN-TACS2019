package utn.tacs.grupo3.telegram.bot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import utn.tacs.grupo3.telegram.bot.handler.CallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.CommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.InlineQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.callbackQuery.AddPlaceToListCallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.callbackQuery.AddPlaceToSelectedListCallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.callbackQuery.ViewPlaceCallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.MyListsCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.SearchCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.StartCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.ViewListCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.inlineQuery.SearchNearMeInlineQueryHandler;

public class PlacesBot extends TelegramLongPollingBot{
	
	private static final String BOT_USERNAME = "TACS20191CGrupo3Bot";
	private static final String BOT_TOKEN = "837736990:AAGVZ27HyFKKyc-ZCbUhgIHE7iddP6-wchY";
	
	private static Map<String, CommandHandler> commands;
	private static final String START_COMMAND = "/start";
	private static final String MY_LISTS_COMMAND = "/mylists";
	private static final String VIEW_LIST_COMMAND = "/viewlist";
	private static final String SEARCH_COMMAND = "/search";
	
	private static Map<String, CallbackQueryHandler> callbackQueries;
	private static final String VIEW_PLACE_CALLBACK = "/viewplace";
	private static final String ADD_PLACE_TO_LIST = "/addplacetolist";
	private static final String ADD_PLACE_TO_SELECTED_LIST = "/addplacetoselectedlist";

	private static Map<String, InlineQueryHandler> inlineQueries;
	private static final String SEARCH_NEAR_ME_INLINE = "search near me";
	
	static {
		commands = new HashMap<String, CommandHandler>();
		commands.put(START_COMMAND, new StartCommandHandler());
		commands.put(MY_LISTS_COMMAND, new MyListsCommandHandler());
		commands.put(VIEW_LIST_COMMAND, new ViewListCommandHandler());
		commands.put(SEARCH_COMMAND, new SearchCommandHandler());
		
		callbackQueries = new HashMap<String, CallbackQueryHandler>();
		callbackQueries.put(VIEW_PLACE_CALLBACK, new ViewPlaceCallbackQueryHandler());
		callbackQueries.put(ADD_PLACE_TO_LIST, new AddPlaceToListCallbackQueryHandler());
		callbackQueries.put(ADD_PLACE_TO_SELECTED_LIST, new AddPlaceToSelectedListCallbackQueryHandler());
		
		inlineQueries = new HashMap<String, InlineQueryHandler>();
		inlineQueries.put(SEARCH_NEAR_ME_INLINE, new SearchNearMeInlineQueryHandler());
		
	}
	
	@Override
	public void onUpdateReceived(Update update) {
		List<BotApiMethod<?>> answers = null;
		
		if (update.hasMessage() && update.getMessage().getText() != null) {
			CommandHandler handler = commands.get(update.getMessage().getText().split("_")[0]);
			answers = handler.handleCommand(update.getMessage());
		}
		if (update.hasCallbackQuery()) {
			CallbackQueryHandler handler = callbackQueries.get(update.getCallbackQuery().getData().split("_")[0]);
			answers = handler.handleCommand(update.getCallbackQuery());
		}
		if (update.hasInlineQuery()) {
			if (inlineQueries.containsKey(update.getInlineQuery().getQuery())) {
				InlineQueryHandler handler = inlineQueries.get(update.getInlineQuery().getQuery());
				answers = handler.handleInlineQuery(update.getInlineQuery());
			}
		}
		
		this.sendAnswers(answers);
	}
	@Override
	public String getBotUsername() {
		return BOT_USERNAME;
	}
	@Override
	public String getBotToken() {
		return BOT_TOKEN;
	}
	
	private void sendAnswers(List<BotApiMethod<?>> answers) {
		if (answers != null) {
			answers.forEach(answer -> {
				try {
					execute(answer);
				} catch (TelegramApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		
	}
	
	
}
