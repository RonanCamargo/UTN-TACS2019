package utn.tacs.grupo3.spring.controller.response;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import utn.tacs.grupo3.service.exception.ApiTacsException;

@Component
public class ResponseHandler {
	private static final Logger logger = Logger.getLogger(ResponseHandler.class.getName());
	
	public Response handle(ResponseFunction<Response> function) {
		try {
			return function.apply();
		} catch (ApiTacsException e) {
    		return new Response(e.getHttpStatus(), e.getMessage(), null);
    	} catch (Exception e) {
    		logger.log(Level.WARNING, e.getMessage(), e);
    		return new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", null);
    	}	}

}
