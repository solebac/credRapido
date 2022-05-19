package com.solebac.credRapido.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.solebac.credRapido.services.exceptions.DataBaseException;
import com.solebac.credRapido.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandErrorPrettyPostman> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Controller not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandErrorPrettyPostman err = new StandErrorPrettyPostman(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandErrorPrettyPostman> dataBaseException(DataBaseException e, HttpServletRequest request){
		String error = "Database erro";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandErrorPrettyPostman err = new StandErrorPrettyPostman(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
	}
}
