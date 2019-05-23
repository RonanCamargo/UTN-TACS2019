package utn.tacs.grupo3.spring.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;


@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(ExceptionbyResourceNotFound.class)
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}