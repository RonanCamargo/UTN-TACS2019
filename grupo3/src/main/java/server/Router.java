package server;

import com.google.gson.Gson;
import controller.AdminController;
import spark.Spark;

public class Router {
	public static void configure() {
		Spark.staticFiles.location("/public");
		Gson gson = new Gson();

		AdminController adminController = new AdminController();
		Spark.get("/usuarios/:name/informacion", adminController::getInformacionDelUsuario, gson::toJson);
		Spark.post("/usuarios/lugaresEnComun", adminController::getLugaresEnComun, gson::toJson);
		Spark.get("lugares/:id/cantidadDeUsuariosInteresados", adminController::getCantidadDeUsuariosInteresadosEnUnLugar, gson::toJson);
		Spark.get("/lugares/registrosTotales/:fecha", adminController::getRegistrosTotalesEnUnaFecha, gson::toJson);
	}

}
