package com.aditya.orderService.client;

import org.springframework.http.HttpStatus;

import com.aditya.orderService.exception.MyCustomBadRequestException;
import com.aditya.orderService.exception.MyCustomServerException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomProductClientErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        
        HttpStatus statusCode=HttpStatus.valueOf(response.status());

        if(statusCode.is4xxClientError()){
            return new MyCustomBadRequestException("Client Error");
        }else if(statusCode.is5xxServerError()){
            return new MyCustomServerException("Server Error");
        }else{
            return defaultErrorDecoder.decode(methodKey, response);
        }
    }

}
