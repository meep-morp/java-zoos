package com.lambdaschool.java_zoos.repositories;

import com.lambdaschool.java_zoos.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepo extends CrudRepository<Zoo, Long> {
}
