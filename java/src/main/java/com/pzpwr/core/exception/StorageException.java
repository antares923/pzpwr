package com.pzpwr.core.exception;

public class StorageException extends Exception {

    String message;

    public StorageException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
