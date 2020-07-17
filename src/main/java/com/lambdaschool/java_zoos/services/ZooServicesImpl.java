package com.lambdaschool.java_zoos.services;

import com.lambdaschool.java_zoos.models.Animal;
import com.lambdaschool.java_zoos.models.Telephone;
import com.lambdaschool.java_zoos.models.Zoo;
import com.lambdaschool.java_zoos.models.ZooAnimals;
import com.lambdaschool.java_zoos.repositories.ZooRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "zooServices")
public class ZooServicesImpl implements ZooServices {

    @Autowired
    ZooRepo zoorepo;

    @Autowired
    AnimalServices animalservices;

    @Override
    public List<Zoo> getAll() {
        List<Zoo> zooList = new ArrayList<>();

        zoorepo.findAll().iterator().forEachRemaining(zooList::add);

        return zooList;
    }

    @Override
    public Zoo save(Zoo zoo) {
        Zoo newZoo = new Zoo();

        if (zoo.getZooid() != 0)
        {
            zoorepo.findById(zoo.getZooid())
                    .orElseThrow(() -> new EntityNotFoundException(String.format("Zoo %s not found.", zoo.getZooid())));
            newZoo.setZooid(zoo.getZooid());
        }


        newZoo.setZooname(zoo.getZooname());

        newZoo.getAnimals()
                .clear();
        for (ZooAnimals a : zoo.getAnimals())
        {
            Animal newAnimal = animalservices.findAnimalById(a.getAnimal().getAnimalid());

            newZoo.getAnimals().add(new ZooAnimals(newZoo, newAnimal));
        }

        newZoo.getTelephones()
                .clear();
        for (Telephone t : zoo.getTelephones())
        {
            newZoo.getTelephones()
                    .add(new Telephone(t.getPhonetype(),t.getPhonenumber(), newZoo));
        }

        return zoorepo.save(newZoo);
    }

    @Override
    public Zoo update(Zoo zoo, long id) {
        Zoo newZoo = new Zoo();

            zoorepo.findById(zoo.getZooid())
                    .orElseThrow(() -> new EntityNotFoundException(String.format("Zoo %s not found.", zoo.getZooid())));
            newZoo.setZooid(zoo.getZooid());

        if(zoo.getZooname() != null) {
            newZoo.setZooname(zoo.getZooname());
        }

        if (zoo.getAnimals().size() != 0) {
            newZoo.getAnimals()
                    .clear();
            for (ZooAnimals a : zoo.getAnimals())
            {
                Animal newAnimal = animalservices.findAnimalById(a.getAnimal().getAnimalid());

                newZoo.getAnimals()
                        .add(new ZooAnimals(newZoo, newAnimal));
            }
        }

        if(zoo.getTelephones().size() != 0) {
            newZoo.getTelephones()
                    .clear();
            for (Telephone t : zoo.getTelephones())
            {
                newZoo.getTelephones()
                        .add(new Telephone(t.getPhonetype(),t.getPhonenumber(), newZoo));
            }
        }

        return zoorepo.save(newZoo);
    }

    @Override
    public Zoo getById(long id) {
      return  zoorepo.findById(id)
              .orElseThrow(() -> new EntityNotFoundException(String.format("Zoo %s not found", id)));
    }

    @Override
    public void delete(long id) {
        zoorepo.deleteById(id);
    }
}
