package mjv.handler;

import java.time.LocalDateTime;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import mjv.exceptions.NotFoundException;
import mjv.exceptions.PostException;

@RestControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NotFoundException.class)
	private ResponseEntity<Object> handlerDelete(NotFoundException nfe, WebRequest request){
		String msg = nfe.getType() == "DELETE" ? "ERRO AO DELETAR ARQUIVO!" : "ARQUIVO NÃO EXISTE!";
		ResponseError error = new ResponseError();
		error.setTime(LocalDateTime.now());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setError(nfe.getMessage());
		error.setStatus(msg);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(nfe, error, headers, HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(PostException.class)
	private ResponseEntity<Object> handlerPost(PostException pex, WebRequest request){
		ResponseError error = new ResponseError();
		error.setTime(LocalDateTime.now());
		error.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		error.setError(pex.getMessage());
		error.setStatus("ARQUIVO JÁ EXISTENTE!");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(pex, error, headers, HttpStatus.NOT_ACCEPTABLE, request);
	}
}
