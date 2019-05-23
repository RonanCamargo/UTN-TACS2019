package utn.tacs.grupo3.telegram;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import utn.tacs.grupo3.telegram.bot.PlacesBot;

public class TelegramBotMain 
{
    public static void main( String[] args )
    {
    	ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        
        
        PlacesBot placesBot = new PlacesBot();
        
//        List<IBotCommand> commands = Arrays.asList(
//        		TelegramCommandFactory.viewListOfPlacesCommand(), 
//        		new SearchPlaceCommand(), 
//        		new AddToListOfPlacesCommand(), 
//        		new CommandListCommand(placesBot),
//        		TelegramCommandFactory.listsOfPlacesCommand());
//        
//        commands.forEach(cmd -> placesBot.register(cmd));
        
        try {
			api.registerBot(placesBot);
			
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
    }
}
