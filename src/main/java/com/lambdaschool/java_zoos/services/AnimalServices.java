package com.lambdaschool.java_zoos.services;

import com.lambdaschool.java_zoos.models.Animal;
import com.lambdaschool.java_zoos.models.Zoo;
import com.lambdaschool.java_zoos.repositories.AnimalRepo;
import com.lambdaschool.java_zoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AnimalServices {
    List<AnimalCount> getCount();
    Animal transferZoo(long id, Zoo zoo);
}
