package com.lambdaschool.java_zoos.controllers;

import com.lambdaschool.java_zoos.services.AnimalServices;
import com.lambdaschool.java_zoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController {

    @Autowired
    AnimalServices animalServices;

//    GET /animals/count - that returns a JSON object list listing the animals and a count of how
//    many zoos where they can be found. Use a custom query for this.
    @GetMapping(value = "/count",
    produces = "application/json")
    public ResponseEntity<?> getAnimalCount() {
        List<AnimalCount> animalList = animalServices.getCount();
        return new ResponseEntity<>(animalList, HttpStatus.OK);
    }
}
