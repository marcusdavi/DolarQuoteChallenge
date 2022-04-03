package com.api.msdollarquotebcb.exception;

public class TodayOrFutureException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TodayOrFutureException(String msg) {
	super(msg);
    }

}
