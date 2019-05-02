package utn.tacs.grupo3.telegram.bot.factory;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MessageFactory {
	
	public static SendMessage createSendMessageWithChatId(Message message){
		return new SendMessage()
				.setChatId(message.getChatId())
				.enableHtml(true);
	}
	
	public static EditMessageText createEditMessage(Message message) {
		EditMessageText editText = new EditMessageText();
		editText.setChatId(message.getChatId());
		editText.setMessageId(message.getMessageId());
		
		return editText;
	}

}
