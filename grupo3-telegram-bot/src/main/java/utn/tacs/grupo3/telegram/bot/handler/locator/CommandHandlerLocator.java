package utn.tacs.grupo3.telegram.bot.handler.locator;

import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.constants.PlacesBotConstants;
import utn.tacs.grupo3.telegram.bot.exception.CommandNotFoundException;
import utn.tacs.grupo3.telegram.bot.handler.CommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.HelpCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.LoginCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.LogoutCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.MyListsCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.SearchCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.StartCommandHandler;
import utn.tacs.grupo3.telegram.bot.handler.command.ViewListCommandHandler;
import utn.tacs.grupo3.telegram.bot.user.CheckUserLogged;
import utn.tacs.grupo3.telegram.bot.user.CheckUserNotLogged;
import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;

public class CommandHandlerLocator {
	
	private static Map<String, CommandHandler> commands;
	private static final LoginStatusChecker CHECK_USER_LOGGED;
	private static final LoginStatusChecker CHECK_USER_NOT_LOGGED;
	
	static {
		CHECK_USER_LOGGED = new CheckUserLogged();
		CHECK_USER_NOT_LOGGED = new CheckUserNotLogged();
		
		commands = new HashMap<String, CommandHandler>();
		commands.put(PlacesBotConstants.START_COMMAND, new StartCommandHandler());
		commands.put(PlacesBotConstants.LOGIN_COMMAND, new LoginCommandHandler(CHECK_USER_NOT_LOGGED));
		commands.put(PlacesBotConstants.MY_LISTS_COMMAND, new MyListsCommandHandler(CHECK_USER_LOGGED));
		commands.put(PlacesBotConstants.VIEW_LIST_COMMAND, new ViewListCommandHandler(CHECK_USER_LOGGED));
		commands.put(PlacesBotConstants.SEARCH_COMMAND, new SearchCommandHandler(CHECK_USER_LOGGED));
		commands.put(PlacesBotConstants.LOGOUT_COMMAND, new LogoutCommandHandler(CHECK_USER_LOGGED));
		commands.put(PlacesBotConstants.HELP_COMMAND, new HelpCommandHandler());
	}
	
	public static CommandHandler getHandler(Message message) {
		String command = message.getText().split(" ")[0].split("_")[0];
		
		if (!commands.containsKey(command)) {
			throw new CommandNotFoundException("Command: \"" + command + "\" is not registered");
		}
		
		return commands.get(command);
	}
}
