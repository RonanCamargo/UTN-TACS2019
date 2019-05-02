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
import utn.tacs.grupo3.telegram.bot.handler.callbackQuery.ViewPlaceCallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.MyListsCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.StartCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.ViewListCommandHandler;

public class PlacesBot extends TelegramLongPollingBot{
	
	private static final String BOT_USERNAME = "TACS20191CGrupo3Bot";
	private static final String BOT_TOKEN = "837736990:AAGVZ27HyFKKyc-ZCbUhgIHE7iddP6-wchY";
	
	private static Map<String, CommandHandler> commands;
	private static final String START_COMMAND = "/start";
	private static final String MY_LISTS_COMMAND = "/mylists";
	private static final String VIEW_LIST_COMMAND = "/viewlist";	
	
	private static Map<String, CallbackQueryHandler> callbackQueries;
	private static final String VIEW_PLACE_CALLBACK = "/viewplace";
	
	static {
		commands = new HashMap<String, CommandHandler>();
		commands.put(START_COMMAND, new StartCommandHandler());
		commands.put(MY_LISTS_COMMAND, new MyListsCommandHandler());
		commands.put(VIEW_LIST_COMMAND, new ViewListCommandHandler());
		
		callbackQueries = new HashMap<String, CallbackQueryHandler>();
		callbackQueries.put(VIEW_PLACE_CALLBACK, new ViewPlaceCallbackQueryHandler());
	}
	
	@Override
	public void onUpdateReceived(Update update) {
		List<BotApiMethod<?>> answers = null;
		
		if (update.hasMessage()) {
			CommandHandler handler = commands.get(update.getMessage().getText().split("_")[0]);
			answers = handler.handleCommand(update.getMessage());
		}
		if (update.hasCallbackQuery()) {
			CallbackQueryHandler handler = callbackQueries.get(update.getCallbackQuery().getData().split("_")[0]);
			answers = handler.handleCommand(update.getCallbackQuery());
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
