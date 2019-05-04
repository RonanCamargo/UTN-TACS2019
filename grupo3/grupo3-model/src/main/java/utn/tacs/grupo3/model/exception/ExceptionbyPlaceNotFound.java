package utn.tacs.grupo3.model.exception;

public class ExceptionbyPlaceNotFound extends ExceptionbyResourceNotFound {
    public ExceptionbyPlaceNotFound(String message) {
        super("Lugar con el id: "+message);
    }
}
