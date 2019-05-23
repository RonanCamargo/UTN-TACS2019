package utn.tacs.grupo3.telegram.bot.user;

import org.telegram.telegrambots.meta.api.objects.User;

public interface LoginStatusChecker {
	
	void checkUserLoginStatus(User user);
	
}
