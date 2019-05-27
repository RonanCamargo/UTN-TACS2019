package utn.tacs.grupo3.telegram.bot.handler.command;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.factory.ReplyKeyboardFactory;
import utn.tacs.grupo3.telegram.bot.handler.AbstractCommandHandler;
import utn.tacs.grupo3.telegram.bot.helper.HtmlHelper;
import utn.tacs.grupo3.telegram.bot.request.exception.BadCredentialsException;
import utn.tacs.grupo3.telegram.bot.user.LoggedUsers;
import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;

public class LoginCommandHandler extends AbstractCommandHandler{
	
	public LoginCommandHandler(LoginStatusChecker loginStatusChecker) {
		super(loginStatusChecker);
	}

	@Override
	public List<BotApiMethod<?>> handle(Message message) {
//		loginStatusChecker.checkUserLoginStatus(message.getFrom());
		
		//TODO Make request
		String token;
		try {
			token = apiRequest.login(getUserCredentialsFromMessage(message));
			
			SendMessage successfulLogin = MessageFactory.createSendMessage(message)
					.setText("Successful login, welcome");
			
			String text = HtmlHelper.formatText(
					HtmlHelper.bold("Select an option please"), HtmlHelper.br(),
					PlacesBotConstants.MY_LISTS_COMMAND, HtmlHelper.br(),
					PlacesBotConstants.SEARCH_COMMAND
					);
			
			SendMessage answer = MessageFactory.createSendMessage(message)
					.setText(text)
					.setReplyMarkup(ReplyKeyboardFactory.createCommandKeyboard());		
			
			LoggedUsers.addLoggedUser(
					message.getFrom().getId(), 
					getUsername(message.getText()), 
					message.getChatId().toString(),
					token);

			return List.of(successfulLogin, answer);
			
		} catch (BadCredentialsException e) {
			SendMessage failedLogin = MessageFactory.createSendMessage(message)
					.setText("You have entered an invalid username or password")
					.setReplyMarkup(ReplyKeyboardFactory.createInitialKeyBoard());
			
			return List.of(failedLogin);
		}
		

	}

}
