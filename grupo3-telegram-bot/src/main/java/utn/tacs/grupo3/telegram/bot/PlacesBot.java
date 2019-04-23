package utn.tacs.grupo3.telegram.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PlacesBot extends TelegramLongPollingBot{
	
	private static final String BOT_USERNAME = "TACS20191CGrupo3Bot";
	private static final String BOT_TOKEN = "837736990:AAGVZ27HyFKKyc-ZCbUhgIHE7iddP6-wchY";

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage()) {
			long chatId = update.getMessage().getChat().getId();
						
			SendMessage sendMessage = new SendMessage(chatId, "Hola");
			
			try {
				execute(sendMessage);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
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

}
