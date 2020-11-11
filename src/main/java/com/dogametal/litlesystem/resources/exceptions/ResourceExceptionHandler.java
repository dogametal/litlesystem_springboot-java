package com.dogametal.litlesystem.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dogametal.litlesystem.services.exceptions.ResourceNotFoundException;

//This annotation responsible to get possible error for treatment
@ControllerAdvice
public class ResourceExceptionHandler {

	//Capture class
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		String error = "Resource not found.";
		HttpStatus status = HttpStatus.NOT_FOUND;
	
		//Personal class create for error treatment
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
}
