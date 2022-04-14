package com.example.stock.controller.handler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.stock.application.business.exception.BookNotFoundException;
import com.example.stock.dto.error.ErrorResponse;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice
public class RestControllerErrorHandler {
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleBookNotFoundException(BookNotFoundException e) {
		return new ErrorResponse("Customer Rest API", e.getMessage());
	}

	

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	public ErrorResponse handleRuntimeException(RuntimeException e) {
		return new ErrorResponse("Application", e.getMessage());
	}
	
	@ExceptionHandler(ExpiredJwtException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorResponse handleExpiredJwtException(ExpiredJwtException e) {
		return new ErrorResponse("Security", e.getMessage());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
		var message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList().toString();
		return new ErrorResponse("Validation", message);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		var message = e.getAllErrors().stream().map(ObjectError::getDefaultMessage).toList().toString();
		return new ErrorResponse("Validation", message);
	}

}
