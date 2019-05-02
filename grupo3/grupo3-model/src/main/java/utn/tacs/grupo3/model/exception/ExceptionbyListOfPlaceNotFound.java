package utn.tacs.grupo3.model.exception;

public class ExceptionbyListOfPlaceNotFound extends ExceptionbyResourceNotFound {
    public ExceptionbyListOfPlaceNotFound(String message) {
        super("Lista De Lugares con el id: "+message);
    }
}
