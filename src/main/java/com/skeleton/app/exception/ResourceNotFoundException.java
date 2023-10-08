package com.skeleton.app.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366163L;

    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }

    public ResourceNotFoundException(final Throwable cause) {
        super(cause);
    }
}
