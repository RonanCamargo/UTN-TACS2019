package utn.tacs.grupo3.telegram.bot.handler.callbackQuery;

import java.io.Serializable;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendVenue;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import utn.tacs.grupo3.telegram.bot.handler.CallbackQueryHandler;
import utn.tacs.grupo3.telegram.bot.request.ApiRequestImpl;
import utn.tacs.grupo3.telegram.bot.request.entity.Place;
import utn.tacs.grupo3.telegram.bot.user.LoggedUsers;

public class ViewPlaceCallbackQueryHandler implements CallbackQueryHandler{

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(CallbackQuery callbackQuery) {
		String[] parsed = callbackQuery.getData().split("_");
		List<Place> places = new ApiRequestImpl().listByName(LoggedUsers.getUsername(callbackQuery.getFrom().getId()), parsed[1]).getPlaces();
		Place place = places.stream().filter(aPlace -> aPlace.getName().equalsIgnoreCase(parsed[2])).findFirst().get();
		//TODO cambiar lat y long hardcodeados
		SendVenue venue = new SendVenue();
		venue.setAddress(place.getLocation())
			.setChatId(callbackQuery.getMessage().getChatId())
			.setTitle(place.getName())
			.setLatitude(-34.598359f)
			.setLongitude(-58.419878f);
		
		return List.of(venue);
	}

}
