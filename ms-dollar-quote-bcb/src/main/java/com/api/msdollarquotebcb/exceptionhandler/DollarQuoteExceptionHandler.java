package com.api.msdollarquotebcb.exceptionhandler;

import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.msdollarquotebcb.exception.NotBusinessDayException;
import com.api.msdollarquotebcb.exception.TodayOrFutureException;

@ControllerAdvice
public class DollarQuoteExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({ DateTimeParseException.class })
    public ResponseEntity<Object> DateTimeParseException(DateTimeParseException ex, WebRequest request) {

	String userMessage = messageSource.getMessage("invalid.date", null, LocaleContextHolder.getLocale());

	return handleExceptionInternal(ex, userMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    }

    @ExceptionHandler({ NotBusinessDayException.class })
    public ResponseEntity<Object> notBusinessDayException(NotBusinessDayException ex, WebRequest request) {

	String userMessage = messageSource.getMessage("not.business.date", new Object[] { ex.getMessage() },
		LocaleContextHolder.getLocale());

	return handleExceptionInternal(ex, userMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    }

    @ExceptionHandler({ TodayOrFutureException.class })
    public ResponseEntity<Object> notTodayOrFutureException(TodayOrFutureException ex, WebRequest request) {

	String userMessage = messageSource.getMessage("today.or.future.date", new Object[] { ex.getMessage() },
		LocaleContextHolder.getLocale());

	return handleExceptionInternal(ex, userMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
	    HttpHeaders headers, HttpStatus status, WebRequest request) {

	return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
