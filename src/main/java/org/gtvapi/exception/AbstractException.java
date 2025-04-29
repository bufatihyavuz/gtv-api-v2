package org.gtvapi.exception;

import lombok.Getter;

@Getter
public abstract class AbstractException extends Exception{

    private String message;

    public AbstractException(String message) {
        this.message = message;
    }
}
