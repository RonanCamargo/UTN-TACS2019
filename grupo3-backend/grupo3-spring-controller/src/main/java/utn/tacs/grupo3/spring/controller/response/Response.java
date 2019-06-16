package utn.tacs.grupo3.spring.controller.response;

import java.util.Collections;

import org.springframework.http.HttpStatus;

public class Response {
	private int status;
	private Object body;

	
	public Response(HttpStatus status, Object body) {
		this.status = status.value();
		this.body = body;
	}
	
	public Response(HttpStatus status, String message) {
		this.status = status.value();
		this.body = Collections.singletonMap("message",message);
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}	
}
