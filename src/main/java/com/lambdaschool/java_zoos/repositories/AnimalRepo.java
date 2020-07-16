package com.lambdaschool.java_zoos.repositories;

import com.lambdaschool.java_zoos.models.Animal;
import com.lambdaschool.java_zoos.views.AnimalCount;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepo extends CrudRepository<Animal, Long> {
    @Query(value = "SELECT  a.animaltype as animaltype, count(z.zooid) as countzoos " +
            "FROM ANIMALS  a LEFT JOIN  ZOOANIMALS z ON a.animalid = z.animalid " +
            "GROUP BY  a.ANIMALTYPE " +
            "ORDER BY  countzoos desc", nativeQuery = true)
        List<AnimalCount> getCount();
}
