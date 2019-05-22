package utn.tacs.grupo3.telegram.bot.handler.command;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.handler.AbstractCommandHandler;
import utn.tacs.grupo3.telegram.bot.helper.HtmlHelper;
import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;

public class MyListsCommandHandler extends AbstractCommandHandler{

	private static final String CLIPBOARD_EMOJI = "\uD83D\uDCCB ";
	
	public MyListsCommandHandler(LoginStatusChecker loginStatusChecker) {
		super(loginStatusChecker);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SendMessage> handleCommand(Message message) {
		loginStatusChecker.checkUserLoginStatus(message.getFrom());
		
		SendMessage answer = MessageFactory.createSendMessage(message);
		
		List<String> myListsNames = apiRequest.listNames(
				getUsernameByUser(message.getFrom()),
				message.getFrom().getId()
				);
		
		StringBuilder text = new StringBuilder(HtmlHelper.bold("My lists")).append(HtmlHelper.multipleBr(2));
		
		myListsNames.forEach(name -> text.append(CLIPBOARD_EMOJI)
				.append(name)
				.append(HtmlHelper.br())
				.append("See places: ")
				.append("/viewlist_")
				.append(name.toLowerCase())
				.append(HtmlHelper.multipleBr(2))
				);
		
		answer.setText(text.toString());
		return List.of(answer);
	}

}
