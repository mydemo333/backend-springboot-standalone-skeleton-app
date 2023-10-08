package com.skeleton.app.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int errorCode;

	private String errorMessage;

	private Date timeStamp;

	public static Error setErrorResponse(int errorCode, String errorMessage) {
		Error error = new Error();
		error.setErrorCode(errorCode);
		error.setErrorMessage(errorMessage);
		error.setTimeStamp(new Date());
		return error;
	}

}


