package server;

import spark.Spark;

public class Router {
	public static void configure() {
		Spark.staticFiles.location("/public");
		Spark.get("/hello", (req, res) -> "Hello mundo");

	}

}
