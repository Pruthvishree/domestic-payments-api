package com.cg.openbanking.payment.domesticPaymentAPI.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.openbanking.payment.domesticPaymentAPI.Exception.BadRequestException;
import com.cg.openbanking.payment.domesticPaymentAPI.Exception.ConsentNotFoundException;
import com.cg.openbanking.payment.domesticPaymentAPI.Exception.DependencyFailedException;
import com.cg.openbanking.payment.domesticPaymentAPI.Exception.ExceptionResponse;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(value = ConsentNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleConsentNotFoundException(ConsentNotFoundException ex,WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage("Data not found");
		exceptionResponse.setHttpCode(HttpStatus.NOT_FOUND.toString());
		exceptionResponse.setRequestDate(new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = DependencyFailedException.class)
	public final ResponseEntity<Object> handleDependencyFailedException(DependencyFailedException ex){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage("Consent is not authorised");
		exceptionResponse.setHttpCode(HttpStatus.FAILED_DEPENDENCY.toString());
		exceptionResponse.setRequestDate(new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FAILED_DEPENDENCY);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage("Method Not Allowed");
		exceptionResponse.setHttpCode(HttpStatus.METHOD_NOT_ALLOWED.toString());
		exceptionResponse.setRequestDate(new Date());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage("Unsupported Media type");
		exceptionResponse.setHttpCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.toString());
		exceptionResponse.setRequestDate(new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	@ExceptionHandler(value = BadRequestException.class)
	public final ResponseEntity<Object> handleBadRequestException(BadRequestException ex){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage("Initiation and Risk sections doesnt match");
		exceptionResponse.setHttpCode(HttpStatus.BAD_REQUEST.toString());
		exceptionResponse.setRequestDate(new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	 @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
		 ExceptionResponse errorDetails = new ExceptionResponse( "Validation Failed",
	        ex.getBindingResult().toString(),new Date());
	    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	  }
	 
	
}
