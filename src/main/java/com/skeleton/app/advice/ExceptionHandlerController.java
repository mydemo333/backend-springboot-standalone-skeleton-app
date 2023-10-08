package com.skeleton.app.advice;

import com.skeleton.app.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.skeleton.app.exception.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) // 401
	@ResponseBody
	public Error notFoundException(ResourceNotFoundException exception) {
		String defaultMsg = "not found data";
		return Error.setErrorResponse(HttpStatus.NOT_FOUND.value(),
				getExceptionMessage(exception.getMessage(), defaultMsg));
	}
	
	 private String getExceptionMessage(String message, String staticMessage) {
	        return (message != null && !message.equals("")) ? message : staticMessage;
	    }

}
