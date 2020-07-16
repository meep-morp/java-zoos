package com.lambdaschool.java_zoos.controllers;

import com.lambdaschool.java_zoos.models.Zoo;
import com.lambdaschool.java_zoos.services.ZooServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController {
    @Autowired
    ZooServices zooServices;

//    GET /zoos/zoos - returns all zoos with their phone numbers and animals
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> getZoos() {
        List<Zoo> zooList = zooServices.getAll();

        return new ResponseEntity<>(zooList, HttpStatus.OK);
    }
//    GET /zoos/zoo/{id} - returns all information related to a zoo based on its id
}
