package utn.tacs.grupo3.telegram.bot.handler;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;

public interface InlineQueryHandler {
	
	List<BotApiMethod<?>> handleInlineQuery(InlineQuery inlineQuery);

}
