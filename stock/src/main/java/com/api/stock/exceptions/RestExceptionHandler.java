package com.api.stock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class) 
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex){
		
		ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}


//handler e um manipulador de exceptions

//exceptionHandler e uma anotation, que vai ficar ouvindo as exceptions, e quando
//acontecer uma exception do tipo ResourceNotFoundException ele vai chamar o metodo
//handlerNotFoundException e passa essa excessao como parametro