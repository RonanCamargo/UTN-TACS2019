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
import utn.tacs.grupo3.telegram.bot.helper.HtmlHelper;
import utn.tacs.grupo3.telegram.bot.request.entity.Place;
import utn.tacs.grupo3.telegram.bot.user.LoggedUsers;
import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;

public class ViewListCommandHandler extends AbstractCommandHandler{

	public ViewListCommandHandler(LoginStatusChecker loginStatusChecker) {
		super(loginStatusChecker);
	}

	@Override
	public <T extends Serializable> List<BotApiMethod<?>> handleCommand(Message message) {
		//TODO refactor
		String listName = message.getText().substring(10);
		List<Place> places = apiRequest.listByName(
				LoggedUsers.getUsername(message.getFrom().getId()),
				listName,
				message.getFrom().getId()).getPlaces();
		
		InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
		List<List<InlineKeyboardButton>> buttons = places.stream().map(place -> List.of(new InlineKeyboardButton(
						place.getName())
						.setCallbackData("/viewplace_" + listName + "_" + place.getName())))
				.collect(Collectors.toList());
		
		keyboard.setKeyboard(buttons);
		
		SendMessage answer = MessageFactory.createSendMessage(message)
				.setText(HtmlHelper.bold("Select a place"))
				.setReplyMarkup(keyboard);
		
		return List.of(answer);
	}

}
