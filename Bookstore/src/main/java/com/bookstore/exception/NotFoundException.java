package com.bookstore.exception;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException
{

	public NotFoundException(String message) {
		super(message);
	}

	    public NotFoundException(String exception,Throwable e){
	        super(exception,e);
	    }
	    
}