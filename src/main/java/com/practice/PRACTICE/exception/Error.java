package com.practice.PRACTICE.exception;

import lombok.Getter;

@Getter
public class Error {
    private int errorCode ;
    private String errorDescription;
    private int debugCode;

    public Error(int errorCode, String errorDescription, int debugCode) {
        super();
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.debugCode = debugCode;
    }
}
