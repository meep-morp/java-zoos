package com.lambdaschool.java_zoos.controllers;

import com.lambdaschool.java_zoos.models.Zoo;
import com.lambdaschool.java_zoos.services.ZooServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    @GetMapping(value = "/zoo/{id}", produces = "application/json")
    public ResponseEntity<?> getZooId(@PathVariable long id) {
        Zoo z = zooServices.getById(id);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

//    POST /zoos/zoo - adds a zoo including new telephone number and zoo animal combinations. The Animal Type must already exist.
//    * In the header return as the location of the newly created zoo POST /zoos/zoo/{id}
    @PostMapping(value = "/zoo", consumes = "application/json")
    public ResponseEntity<?> postZoo(@Valid @RequestBody Zoo zoo) {
        zoo.setZooid(0);
        Zoo newZoo = zooServices.save(zoo);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{zooid}")
                .buildAndExpand(newZoo.getZooid())
                .toUri();
        responseHeaders.setLocation(newZooURI);

        return new ResponseEntity<>(null ,responseHeaders, HttpStatus.CREATED);
    }
//    PUT /zoos/zoo/{id} - Completely replace the zoo record and all accompany records based off of the given zoo id.
    @PutMapping(value = "/zoo/{id}", consumes = "application/json")
    public ResponseEntity<?> putZoo(@Valid @RequestBody Zoo zoo, @PathVariable long id) {
        zoo.setZooid(id);
        zooServices.save(zoo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    PATCH /zoos/zoo{id} - Updates the zoo with new information. Only the new data is to be sent from the frontend client.
    @PatchMapping(value = "/zoo/{id}", consumes = "application/json")
    public ResponseEntity<?> patchZoo(@Valid @RequestBody Zoo zoo, @PathVariable long id) {
        zooServices.update(zoo, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    DELETE /zoos/zoo/{id} - delete the zoo, associated phone numbers, and zoo animals combination associated with this zoo id
    @DeleteMapping(value = "/zoo/{id}")
    public ResponseEntity<?> deleteByZooId(@PathVariable long id) {
        zooServices.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
