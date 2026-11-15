package com.aditya.orderService.exception;

public class MyCustomServerException extends RuntimeException{
    
    public MyCustomServerException(String mssg){
        super(mssg);
    }
}
