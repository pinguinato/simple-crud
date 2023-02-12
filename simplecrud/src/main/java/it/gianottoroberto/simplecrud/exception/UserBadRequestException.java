package it.gianottoroberto.simplecrud.exception;

public class UserBadRequestException extends Exception {

    public UserBadRequestException(String errorMessage) {
        super(errorMessage);
    }

}
