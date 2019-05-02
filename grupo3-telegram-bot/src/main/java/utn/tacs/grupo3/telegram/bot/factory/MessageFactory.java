package utn.tacs.grupo3.telegram.bot.factory;

import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MessageFactory {
	
	public static SendMessage createSendMessage(Message message){
		return new SendMessage()
				.setChatId(message.getChatId())
				.enableHtml(true);
	}
	
	public static EditMessageText createEditMessage(Message message) {
		return new EditMessageText()
				.setChatId(message.getChatId())
				.setMessageId(message.getMessageId());
	}
	
	public static SendLocation createSendLocation(Message message) {
		return new SendLocation()
				.setChatId(message.getChatId());
	}

}
