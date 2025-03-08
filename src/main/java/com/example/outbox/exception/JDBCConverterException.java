package com.example.outbox.exception;

/**
 * Created by Sherif.Abdulraheem 3/8/2025 - 4:56 PM
 **/
public class JDBCConverterException extends RuntimeException{
    public JDBCConverterException(String message, Throwable cause) {
        super(message, cause);
    }
}
