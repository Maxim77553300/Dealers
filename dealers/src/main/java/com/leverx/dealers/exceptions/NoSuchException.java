package com.leverx.dealers.exceptions;

public class NoSuchException extends RuntimeException{

    public NoSuchException(String message) {
        super(message);
    }

    public NoSuchException() {
        super("No such element !!! Please try again!!" );
    }
}
