package com.api.msdollarquotebcb.exception;

public class NotBusinessDayException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotBusinessDayException(String msg) {
	super(msg);
    }

}
