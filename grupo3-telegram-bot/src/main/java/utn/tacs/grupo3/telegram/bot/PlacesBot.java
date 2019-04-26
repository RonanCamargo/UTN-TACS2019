package utn.tacs.grupo3.telegram.bot;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class PlacesBot extends TelegramLongPollingCommandBot{
	
	private static final String BOT_USERNAME = "TACS20191CGrupo3Bot";
	private static final String BOT_TOKEN = "837736990:AAGVZ27HyFKKyc-ZCbUhgIHE7iddP6-wchY";
	
	
	public PlacesBot() {
		super(BOT_USERNAME);
	}
	
	@Override
	public void processNonCommandUpdate(Update update) {
		//Do nothing
	}
	
	@Override
	public String getBotToken() {
		return BOT_TOKEN;
	}
}
