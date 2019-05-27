package utn.tacs.grupo3.telegram.bot.handler.command;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.exception.ParseException;
import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.factory.ReplyKeyboardFactory;
import utn.tacs.grupo3.telegram.bot.handler.AbstractCommandHandler;
import utn.tacs.grupo3.telegram.bot.helper.HtmlHelper;
import utn.tacs.grupo3.telegram.bot.request.exception.BadCredentialsException;
import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;
import utn.tacs.grupo3.telegram.bot.user.UserCredentials;

/**
 * Handler for /login command
 *
 */
public class LoginCommandHandler extends AbstractCommandHandler{
	
	public LoginCommandHandler(LoginStatusChecker loginStatusChecker) {
		super(loginStatusChecker);
	}

	@Override
	public List<BotApiMethod<?>> handle(Message message) {
		UserCredentials credentials = getUserCredentials(message.getText());
		
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

		try {			
			apiRequest.login(credentials, message.getFrom().getId());			

			return List.of(successfulLogin, answer);
			
		} catch (BadCredentialsException e) {
			SendMessage failedLogin = MessageFactory.createSendMessage(message)
					.setText("You have entered an invalid username or password")
					.setReplyMarkup(ReplyKeyboardFactory.createInitialKeyBoard());
			
			return List.of(failedLogin);
		}

	}
	
	private UserCredentials getUserCredentials(String text) {
		String[] parsed = text.split("\\s+"); // \s is a regex for blank space
		
		if (parsed.length != 3) {
			throw new ParseException("Invalid format. It must be /login USERNAME PASSWORD");
		}		
		return new UserCredentials(parsed[1], parsed[2]);		
	}
}
