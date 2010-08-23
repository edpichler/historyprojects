package com.dudhoo.evilframework.exception;

public class ValidationException extends Exception {
    public ValidationException(String st) {
        super(st);
    }
    public ValidationException(String st, Throwable bl) {
        super(st, bl);
    }
}
