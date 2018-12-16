package com.jc.tictactoe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author miguel.reyes on 2018-12-16.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
