package utn.tacs.grupo3.telegram.bot.handler.command;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.handler.CommandHandler;
import utn.tacs.grupo3.telegram.bot.helper.HtmlHelper;
import utn.tacs.grupo3.telegram.bot.mock.repo.ListOfPlacesRepo;

public class MyListsCommandHandler implements CommandHandler{

	private static final String EMOJI = "\u2194 ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SendMessage> handleCommand(Message message) {
		SendMessage answer = MessageFactory.createSendMessageWithChatId(message);
		
		List<String> myListsNames = ListOfPlacesRepo.listNames();
		
		StringBuilder text = new StringBuilder(HtmlHelper.bold("Mis listas")).append(HtmlHelper.multipleBr(2));
		
		myListsNames.forEach(name -> text.append(EMOJI)
				.append(name).append(HtmlHelper.br())
				.append("Ver: ").append("/mylist_").append(name.toLowerCase())
				.append(HtmlHelper.multipleBr(2))
				);
		
		answer.setText(text.toString());
		return List.of(answer);
	}

}
