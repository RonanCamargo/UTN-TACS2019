package utn.tacs.grupo3.telegram.bot.handler.command;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.handler.AbstractCommandHandler;
import utn.tacs.grupo3.telegram.bot.mock.repo.ListOfPlacesRepo;
import utn.tacs.grupo3.telegram.bot.mock.repo.Place;
import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;

public class ViewListCommandHandler extends AbstractCommandHandler{

	public ViewListCommandHandler(LoginStatusChecker loginStatusChecker) {
		super(loginStatusChecker);
	}

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(Message message) {
		String listName = message.getText().substring(10);
		List<Place> places = ListOfPlacesRepo.places(listName);
		
		InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
		List<List<InlineKeyboardButton>> buttons = List.of(
				places.stream().map(place -> new InlineKeyboardButton(
						place.getName())
						.setCallbackData("/viewplace_" + listName + "_" + place.getName()))
				.collect(Collectors.toList())
				);
		keyboard.setKeyboard(buttons);
		
		SendMessage answer = MessageFactory.createSendMessage(message)
				.setText("<b>Seleccione un lugar</b>")
				.setReplyMarkup(keyboard);
		
		return List.of(answer);
	}

}
