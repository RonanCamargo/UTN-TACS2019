package utn.tacs.grupo3.telegram.bot.helper;

public class HtmlHelper {
	
	public static String bold(String toBold) {
		return "<b>" + toBold + "</b>";
	}
	
	public static String italic(String toItalic) {
		return "<i>" + toItalic + "</i>";
	}
	
	public static String br() {
		return "\n";
	}
	
	public static String multipleBr(int count) {
		return br().repeat(count);
	}
	
	public static String formatText(String...args) {
		StringBuilder text = new StringBuilder();
		
		for (String string : args) {
			text.append(string);
		}
		
		return text.toString();
	}

}
