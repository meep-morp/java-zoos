package com.lambdaschool.java_zoos.services;

import com.lambdaschool.java_zoos.models.Zoo;

import java.util.List;

public interface ZooServices {
    List<Zoo> getAll();
    Zoo save(Zoo zoo);
    Zoo update(Zoo zoo, long id);
    Zoo getById(long id);
    void delete(long id);
}
