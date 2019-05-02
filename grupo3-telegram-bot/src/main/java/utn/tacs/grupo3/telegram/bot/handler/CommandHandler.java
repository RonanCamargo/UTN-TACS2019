package utn.tacs.grupo3.telegram.bot.handler;

import java.io.Serializable;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandHandler {

	<T extends Serializable> List<BotApiMethod<?>> handleCommand(Message message);

}
