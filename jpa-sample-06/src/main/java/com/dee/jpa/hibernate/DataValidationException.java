package com.dee.jpa.hibernate;

/**
 * @author dien.nguyen
 */

public class DataValidationException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public DataValidationException(String message) {
        super(message);
    }

}
