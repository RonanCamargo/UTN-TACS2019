package utn.tacs.grupo3.telegram;

import java.util.Arrays;
import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import utn.tacs.grupo3.telegram.bot.PlacesBot;
import utn.tacs.grupo3.telegram.bot.command.AddToListOfPlacesCommand;
import utn.tacs.grupo3.telegram.bot.command.CommandListCommand;
import utn.tacs.grupo3.telegram.bot.command.SearchPlaceCommand;
import utn.tacs.grupo3.telegram.bot.command.ViewListOfPlacesCommand;

public class TelegramBotMain 
{
    public static void main( String[] args )
    {
    	ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        
        PlacesBot placesBot = new PlacesBot();
        
        List<IBotCommand> commands = Arrays.asList(
        		new ViewListOfPlacesCommand(), 
        		new SearchPlaceCommand(), 
        		new AddToListOfPlacesCommand(), 
        		new CommandListCommand(placesBot));
        
        commands.forEach(cmd -> placesBot.register(cmd));
        
        try {
			api.registerBot(placesBot);
			
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
    }
}
