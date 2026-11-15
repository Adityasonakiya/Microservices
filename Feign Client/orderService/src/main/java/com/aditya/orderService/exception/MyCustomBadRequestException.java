package com.aditya.orderService.exception;

public class MyCustomBadRequestException extends RuntimeException {
    
    public MyCustomBadRequestException(String mssg){
        super(mssg);
    }
}
