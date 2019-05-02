package utn.tacs.grupo3.telegram.bot.handler.callbackQuery;

import java.io.Serializable;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.handler.CallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.helper.HtmlHelper;
import utn.tacs.grupo3.telegram.bot.mock.repo.ListOfPlacesRepo;
import utn.tacs.grupo3.telegram.bot.mock.repo.Place;

public class ViewPlaceCallbackQueryHandler implements CallbackQueryHandler{

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(CallbackQuery callbackQuery) {
		String[] parsed = callbackQuery.getData().split("_");
		List<Place> places = ListOfPlacesRepo.places(parsed[1]);
		Place place = ListOfPlacesRepo.placeByName(parsed[2], places);
		
		SendMessage title = MessageFactory.createSendMessage(callbackQuery.getMessage())
				.setText(new StringBuilder()
						.append(HtmlHelper.bold(place.getName()))
						.append(HtmlHelper.br())
						.append("Lat: ").append(place.getLat())
						.append(" ")
						.append("Long: ").append(place.getLongit())
						.toString());
		
		SendLocation location = MessageFactory.createSendLocation(callbackQuery.getMessage())
				.setLatitude(place.getLat())
				.setLongitude(place.getLongit());				
		
		return List.of(title, location);
	}

}
