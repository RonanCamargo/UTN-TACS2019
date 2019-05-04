package utn.tacs.grupo3.telegram.bot.handler;

import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;

public abstract class AbstractCommandHandler implements CommandHandler{
	
	protected LoginStatusChecker loginStatusChecker;
		
	public AbstractCommandHandler(LoginStatusChecker loginStatusChecker) {
		this.loginStatusChecker = loginStatusChecker;
	}

}
