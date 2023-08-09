package com.test.property_management_system.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> response(String message, HttpStatus status, Object object){

        Map<String,Object> map = new HashMap<>();
        map.put("data", object);
        map.put("message",message);

        return new ResponseEntity<>(map, status);
    }
}
