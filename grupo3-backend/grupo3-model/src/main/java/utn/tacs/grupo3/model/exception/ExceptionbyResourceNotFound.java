package utn.tacs.grupo3.model.exception;

public class ExceptionbyResourceNotFound extends Exception {

    private String message;

    public ExceptionbyResourceNotFound(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "no existe el recurso "+message;
    }
}
