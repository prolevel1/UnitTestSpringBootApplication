package com.practice.PRACTICE.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectNotFound extends Exception{
    public ObjectNotFound(String message) {
        super(message);
    }
}
