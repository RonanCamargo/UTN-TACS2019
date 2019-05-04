package utn.tacs.grupo3.telegram.bot.handler.command;

import java.io.Serializable;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.handler.CommandHandler;

public class HelpCommandHandler implements CommandHandler{

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

}
