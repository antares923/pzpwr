package com.pzpwr.core.exception;

public class NoFreeRoomException extends Exception {

    private String message;

    public NoFreeRoomException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
