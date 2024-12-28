package com.learning.helidon;

public class CountryServiceException extends Exception {
    int code;

    public CountryServiceException() { super(); }

    public CountryServiceException(String message) {
        super(message);
    }

    public CountryServiceException(int code, String message) {
        this(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
