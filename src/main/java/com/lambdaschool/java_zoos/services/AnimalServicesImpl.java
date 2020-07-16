package com.lambdaschool.java_zoos.services;

import com.lambdaschool.java_zoos.models.Animal;
import com.lambdaschool.java_zoos.models.Zoo;
import com.lambdaschool.java_zoos.repositories.AnimalRepo;
import com.lambdaschool.java_zoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "animalServices")
public class AnimalServicesImpl implements AnimalServices {

    @Autowired
    AnimalRepo animalrepos;

    @Override
    public List<AnimalCount> getCount() {
        return animalrepos.getCount();
    }

    @Override
    public Animal transferZoo(long id, Zoo zoo) {
        return null;
    }
}
