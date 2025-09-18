package com.solvd.taxi.model;

public class NoAvailableDriverException extends Exception{
    public NoAvailableDriverException(String message){
        super(message);
    }
}
