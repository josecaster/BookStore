package org.example.exceptions;

public class DatabaseException extends Exception{

    public DatabaseException(String message) {
        super("My Database Exception "+message);
    }
}
