package controller;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import utn.tacs.grupo3.model.Usuario;
import utn.tacs.grupo3.repository.UsuarioRepository;

import java.util.List;

public class AdminController {

    private static Gson GSON = new Gson();
    private UsuarioRepository usuarioRepository = new UsuarioRepository();
    private static String CONTENT_TYPE = "Content-Type";
    private static String APPLICATION_JSON = "application/json";

    public List<Usuario> getInformacionDelUsuario(Request request, Response response) {
        String name = request.params("name");
        response.header(CONTENT_TYPE, APPLICATION_JSON);

        return usuarioRepository.usuariosByNombre(name);
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
