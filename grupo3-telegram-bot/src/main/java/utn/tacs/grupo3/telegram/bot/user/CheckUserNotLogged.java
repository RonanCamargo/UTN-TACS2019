package utn.tacs.grupo3.telegram.bot.user;

import org.telegram.telegrambots.meta.api.objects.User;

public class CheckUserNotLogged implements LoginStatusChecker{

	@Override
	public void checkUserLoginStatus(User user) {
		if (LoggedUsers.isLogged(user.getId())) {
			throw new RuntimeException("User: " + user.getId() + " should not be logged");
		}
	}

}
