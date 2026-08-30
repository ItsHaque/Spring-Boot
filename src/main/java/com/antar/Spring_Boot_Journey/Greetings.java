package com.antar.Spring_Boot_Journey;

public class Greetings {
    private String message;
    private int code;
    Greetings(String message, int code){
        this.setMessage(message);
        this.setCode(code);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
