package utn.tacs.grupo3.spark.controller;

import java.util.List;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.repository.UserRepository;

public class AdminController {

    private static Gson GSON = new Gson();
    private UserRepository userRepository = new UserRepository();
    private static String CONTENT_TYPE = "Content-Type";
    private static String APPLICATION_JSON = "application/json";

    public List<User> getInformacionDelUsuario(Request request, Response response) {
        String name = request.params("name");
        response.header(CONTENT_TYPE, APPLICATION_JSON);

        return userRepository.usuariosByNombre(name);
    }

    public String getLugaresEnComun(Request request, Response response) {
        return "3";
    }

    public String getCantidadDeUsuariosInteresadosEnUnLugar(Request request, Response response) {
        return "1";
    }

    public String getRegistrosTotalesEnUnaFecha(Request request, Response response) {
        return "6";
    }
}
