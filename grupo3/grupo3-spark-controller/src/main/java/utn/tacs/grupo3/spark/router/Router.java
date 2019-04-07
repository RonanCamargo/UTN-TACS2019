package utn.tacs.grupo3.spark.router;

import com.google.gson.Gson;
import utn.tacs.grupo3.spark.controller.AdminController;
import spark.Spark;

public class Router {
	public static void configure() {
		Spark.staticFiles.location("/public");
		Gson gson = new Gson();

		AdminController adminController = new AdminController();
		Spark.get("/usuarios/:id", adminController::getInformacionDelUsuario, gson::toJson);
		Spark.get("/lugares_en_comun/usuarios", adminController::getLugaresEnComun, gson::toJson);
		Spark.get("/lugares/:id/usuarios_interesados", adminController::getCantidadDeUsuariosInteresadosEnUnLugar, gson::toJson);
		Spark.get("/lugares/registrados_hasta_la_fecha", adminController::getRegistrosTotalesEnUnaFecha, gson::toJson);
	}

}
