package utn.tacs.grupo3.telegram.bot.handler.command;

import java.io.Serializable;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.factory.ReplyKeyboardFactory;
import utn.tacs.grupo3.telegram.bot.handler.CommandHandler;
import utn.tacs.grupo3.telegram.bot.helper.HtmlHelper;

public class LoginCommandHandler implements CommandHandler{

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(Message message) {
		String text = HtmlHelper.formatText(
				HtmlHelper.bold("Sesión iniciada correctamente"),
				HtmlHelper.br(),
				"Bienvenido, seleccione una opción por favor"
				);
		
		SendMessage answer = MessageFactory.createSendMessage(message)
				.setText(text)
				.setReplyMarkup(ReplyKeyboardFactory.createCommandKeyboard());		
		
		return List.of(answer);
	}

}
