package utn.tacs.grupo3.spark;

import spark.Spark;
import spark.debug.DebugScreen;
import utn.tacs.grupo3.spark.router.Router;

public class Application {
	
	public static void main(String[] args) {
		Spark.port(8080);
		DebugScreen.enableDebugScreen();
		Router.configure();

	}

}
	