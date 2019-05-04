package utn.tacs.grupo3.telegram.bot.handler.command;

import java.io.Serializable;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.factory.ReplyKeyboardFactory;
import utn.tacs.grupo3.telegram.bot.handler.AbstractCommandHandler;
import utn.tacs.grupo3.telegram.bot.helper.HtmlHelper;
import utn.tacs.grupo3.telegram.bot.user.LoggedUsers;
import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;

public class LoginCommandHandler extends AbstractCommandHandler{
	
	public LoginCommandHandler(LoginStatusChecker loginStatusChecker) {
		super(loginStatusChecker);
	}

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(Message message) {
		loginStatusChecker.checkUserLoginStatus(message.getFrom());
		
		//TODO Make request
		
		SendMessage successfullLogin = MessageFactory.createSendMessage(message)
				.setText("Successful login, welcome");
		
		String text = HtmlHelper.formatText(
				HtmlHelper.bold("Select an option please"), HtmlHelper.br(),
				PlacesBotConstants.MY_LISTS_COMMAND, HtmlHelper.br(),
				PlacesBotConstants.SEARCH_COMMAND
				);
		
		SendMessage answer = MessageFactory.createSendMessage(message)
				.setText(text)
				.setReplyMarkup(ReplyKeyboardFactory.createCommandKeyboard());		
		
		LoggedUsers.addLoggedUser(message.getFrom().getId(), "Ronan");

		return List.of(successfullLogin, answer);
	}

}
