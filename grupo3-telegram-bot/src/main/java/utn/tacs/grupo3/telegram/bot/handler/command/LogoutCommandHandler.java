package utn.tacs.grupo3.telegram.bot.handler.command;

import java.util.List;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import utn.tacs.grupo3.telegram.bot.factory.MessageFactory;
import utn.tacs.grupo3.telegram.bot.factory.ReplyKeyboardFactory;
import utn.tacs.grupo3.telegram.bot.handler.AbstractCommandHandler;
import utn.tacs.grupo3.telegram.bot.helper.HtmlHelper;
import utn.tacs.grupo3.telegram.bot.user.LoginStatusChecker;

public class LogoutCommandHandler extends AbstractCommandHandler{
	
	public LogoutCommandHandler(LoginStatusChecker loginStatusChecker) {
		super(loginStatusChecker);
	}

	@Override
	public List<BotApiMethod<?>> handle(Message message) {
//		loginStatusChecker.checkUserLoginStatus(message.getFrom());

		apiRequest.logout(message.getFrom().getId());
		
		SendMessage answer = MessageFactory.createSendMessage(message)
				.setText(HtmlHelper.bold("Successful logout"))
				.setReplyMarkup(ReplyKeyboardFactory.createInitialKeyBoard());
		
		return List.of(answer);
		
	}

}
