package it.gianottoroberto.simplecrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{

    private String message;

    public UserNotFoundException(String message) {
        super(message);
    }

}
