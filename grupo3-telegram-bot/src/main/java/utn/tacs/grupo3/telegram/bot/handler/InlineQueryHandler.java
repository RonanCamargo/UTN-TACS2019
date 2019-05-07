package utn.tacs.grupo3.telegram.bot.handler;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;

import utn.tacs.grupo3.telegram.bot.request.ApiRequest;
import utn.tacs.grupo3.telegram.bot.request.ApiRequestImpl;

/**
 * Interface for Telegram-inline-queries handlers 
 *
 */
public interface InlineQueryHandler {
	
	public static ApiRequest apiRequest = new ApiRequestImpl();
	
	List<BotApiMethod<?>> handleInlineQuery(InlineQuery inlineQuery);

}
