package com.lambdaschool.java_zoos.repositories;

import com.lambdaschool.java_zoos.models.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepo extends CrudRepository<Animal, Long> {
}
