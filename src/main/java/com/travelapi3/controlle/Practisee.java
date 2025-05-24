package com.travelapi3.controlle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Practisee {

    @GetMapping("/get")
    public ResponseEntity getMessage(){

        return new ResponseEntity("hello Prajwal!!!",HttpStatus.OK);
    }
}
