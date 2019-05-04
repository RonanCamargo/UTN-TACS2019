package utn.tacs.grupo3.telegram.bot.handler.locator;

import java.util.HashMap;
import java.util.Map;

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

public class CommandQueryHandlerLocator {
	
	private static Map<String, CommandHandler> commands;

	
	static {
		commands = new HashMap<String, CommandHandler>();
		commands.put(PlacesBotConstants.START_COMMAND, new StartCommandHandler());
		commands.put(PlacesBotConstants.LOGIN_COMMAND, new LoginCommandHandler());
		commands.put(PlacesBotConstants.MY_LISTS_COMMAND, new MyListsCommandHandler());
		commands.put(PlacesBotConstants.VIEW_LIST_COMMAND, new ViewListCommandHandler());
		commands.put(PlacesBotConstants.SEARCH_COMMAND, new SearchCommandHandler());
		commands.put(PlacesBotConstants.LOGOUT_COMMAND, new LogoutCommandHandler());
		commands.put(PlacesBotConstants.HELP_COMMAND, new HelpCommandHandler());
	}
	
	public static CommandHandler getHandler(String command) {
		if (!commands.containsKey(command)) {
			throw new CommandNotFoundException("Command: " + command + "is not registered");
		}
		
		return commands.get(command);
	}
}
