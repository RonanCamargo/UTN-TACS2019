package utn.tacs.grupo3.telegram.bot.helper;

public class HtmlHelper {
	
	public static String bold(String toBold) {
		return "<b>" + toBold + "</b>";
	}
	
	public static String italic(String toItalic) {
		return "<i>" + toItalic + "</b>";
	}
	
	public static String br() {
		return "\n";
	}
	
	public static String multipleBr(int count) {
		return br().repeat(count);
	}

}
