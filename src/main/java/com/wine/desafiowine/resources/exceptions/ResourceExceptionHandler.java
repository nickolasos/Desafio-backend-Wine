package com.wine.desafiowine.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wine.desafiowine.services.exceptions.ConflitoFaixaCepException;
import com.wine.desafiowine.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request ){
		
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(ConflitoFaixaCepException.class)
	public ResponseEntity<StandardError> conflitoFaixa(ConflitoFaixaCepException e, HttpServletRequest request ){
		
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(FaixaCepInvalidaException.class)
	public ResponseEntity<StandardError> faixaCepInvalida(FaixaCepInvalidaException e, HttpServletRequest request ){
		
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> faixaCepInvalida(Exception e, HttpServletRequest request ){
		
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	
}
