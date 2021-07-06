package mjv.handler;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import mjv.exceptions.DeleteException;

@RestControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler{
	@Resource
	private MessageSource message;
	
	/*@ExceptionHandler(Exception.class)
	private ResponseEntity<Object> general(DeleteException ex, WebRequest request){
		if(ex.getClass().isAssignableFrom(DeleteException.class)) {
		ResponseError error = new ResponseError();
		error.setTime(LocalDate.now());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setError(ex.getMessage());
		return handleBusinessException(ex, request);
		} else return handleException(ex, request);
	}*/
}
