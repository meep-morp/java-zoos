package com.lambdaschool.java_zoos.services;

import com.lambdaschool.java_zoos.models.Zoo;
import com.lambdaschool.java_zoos.repositories.ZooRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "zooServices")
public class ZooServicesImpl implements ZooServices {

    @Autowired
    ZooRepo zoorepo;

    @Override
    public List<Zoo> getAll() {
        List<Zoo> zooList = new ArrayList<>();

        zoorepo.findAll().iterator().forEachRemaining(zooList::add);

        return zooList;
    }
}
