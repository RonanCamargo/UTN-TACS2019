package utn.tacs.grupo3.telegram.bot.user;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores logged users in a map (Key: TelegramId, Value: Username) 
 *
 */
public final class LoggedUsers {
	
	private static Map<Integer, String> loggedUsers;
	
	static {
		loggedUsers = new HashMap<Integer, String>();
	}
	
	public static void addLoggedUser(Integer telegramId, String username) {
		loggedUsers.put(telegramId, username);
	}
	
	public static void removeLoggedUser(Integer telegramId) {
		loggedUsers.remove(telegramId);
	}
	
	public static boolean isLogged(Integer telegramId) {
		return loggedUsers.containsKey(telegramId);
	}

}
