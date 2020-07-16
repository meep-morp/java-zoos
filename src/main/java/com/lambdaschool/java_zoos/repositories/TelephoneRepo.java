package com.lambdaschool.java_zoos.repositories;

import com.lambdaschool.java_zoos.models.Telephone;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneRepo extends CrudRepository<Telephone, Long> {
}
