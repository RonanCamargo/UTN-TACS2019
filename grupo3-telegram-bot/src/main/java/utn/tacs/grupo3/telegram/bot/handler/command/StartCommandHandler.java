package utn.tacs.grupo3.telegram.bot.handler.command;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.factory.ReplyKeyboardFactory;
import utn.tacs.grupo3.telegram.bot.handler.CommandHandler;

public class StartCommandHandler implements CommandHandler{

	private static final String START_MESSAGE = "<b>Bienvenido a UTN Places Bot</b>\n\n"			
			+ "Por favor inicie sesión enviando su usuario y contraseña en el siguiente formato\n"
			+ "/login USUARIO, CONTRASEÑA";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SendMessage> handleCommand(Message message) {
		SendMessage answer = MessageFactory.createSendMessage(message);
		answer.setText(START_MESSAGE);
		
		answer.setReplyMarkup(ReplyKeyboardFactory.createCommandKeyboard());
		
		return List.of(answer);
	}

}