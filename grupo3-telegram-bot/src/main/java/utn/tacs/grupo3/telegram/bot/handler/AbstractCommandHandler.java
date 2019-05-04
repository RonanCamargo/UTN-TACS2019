package utn.tacs.grupo3.telegram.bot.handler;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.request.ApiRequest;
import utn.tacs.grupo3.telegram.bot.request.MockApiRequest;
import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;

public abstract class AbstractCommandHandler implements CommandHandler{
	
	protected LoginStatusChecker loginStatusChecker;
	
	protected ApiRequest apiRequest;
	
	public AbstractCommandHandler() {}
		
	public AbstractCommandHandler(LoginStatusChecker loginStatusChecker) {
		this.loginStatusChecker = loginStatusChecker;
		this.apiRequest = new MockApiRequest();
	}

	protected String getUsername(String messageText) {
		return messageText.replaceAll("\\s+", "").split(PlacesBotConstants.LOGIN_COMMAND)[1].split(",")[0];
	}
	
	protected String getPassword(String messageText) {
		return messageText.replaceAll("\\s+", "").split(PlacesBotConstants.LOGIN_COMMAND)[1].split(",")[1];
	}
	
}
