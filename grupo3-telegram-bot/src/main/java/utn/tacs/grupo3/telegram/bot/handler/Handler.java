package utn.tacs.grupo3.telegram.bot.handler;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

public interface Handler<T> {
	
	List<BotApiMethod<?>> handle(T input);
	
}
