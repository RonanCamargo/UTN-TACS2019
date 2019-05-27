package utn.tacs.grupo3.telegram.bot.handler;

import java.util.List;

import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

public interface Handler<T extends BotApiObject> {
	
	List<BotApiMethod<?>> handle(T input);
	
}
