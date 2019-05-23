package utn.tacs.grupo3.model.exception;

public class ExceptionbyUserNotFound extends ExceptionbyResourceNotFound {
    public ExceptionbyUserNotFound(String message) {
        super("Usuario con el id: "+ message);
    }
}
