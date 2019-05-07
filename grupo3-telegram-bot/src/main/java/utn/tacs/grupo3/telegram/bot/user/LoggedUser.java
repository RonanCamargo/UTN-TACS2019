package utn.tacs.grupo3.telegram.bot.user;

public class LoggedUser {
	
	private String userName;
	private String chatId;
		
	public LoggedUser(String userName, String chatId) {
		super();
		this.userName = userName;
		this.chatId = chatId;
	}
	
	public String getUserName() {
		return userName;
	}
	public String getChatId() {
		return chatId;
	}
	
	

}
