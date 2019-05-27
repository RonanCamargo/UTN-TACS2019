package utn.tacs.grupo3.telegram.bot.handler;


import org.telegram.telegrambots.meta.api.objects.User;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.request.ApiRequest;
import utn.tacs.grupo3.telegram.bot.request.ApiRequestImpl;
import utn.tacs.grupo3.telegram.bot.user.LoggedUsers;
import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;

public abstract class AbstractCommandHandler implements CommandHandler{
	
	protected LoginStatusChecker loginStatusChecker;
	
	protected ApiRequest apiRequest;
	
	public AbstractCommandHandler() {}
		
	public AbstractCommandHandler(LoginStatusChecker loginStatusChecker) {
		this.loginStatusChecker = loginStatusChecker;
		this.apiRequest = new ApiRequestImpl();
	}
	
	protected String getUsernameByUser(User user) {
		return LoggedUsers.getUsername(user.getId());
	}
	
	protected String removeCommandFromMessageText(String message, String command) {
		if (message.startsWith(command + PlacesBotConstants.COMMAND_SEPARATOR)) {
			return message.substring(command.length() + 1);
		} else {
			return message.substring(command.length());
		}
			
	}
	
}
