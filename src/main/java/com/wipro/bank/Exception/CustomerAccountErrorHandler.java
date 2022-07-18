package com.wipro.bank.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerAccountErrorHandler {

	@ExceptionHandler(CustomerAccountNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleCustomerAccountNotFound(CustomerAccountNotFoundException cnf) {
		System.out.println("CustomerAccountErrorHandler.handleCustomerAccountNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), cnf.getMessage(), "404- Customer Not Found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e) {
		System.out.println("CustomerAccountErrorHandler.handleAllProblems()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Problem in execution");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
