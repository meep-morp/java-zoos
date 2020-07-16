package com.lambdaschool.java_zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    private String animaltype;

    @OneToMany(mappedBy = "animal",
                cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "animal",
                        allowSetters = true)
    private Set<ZooAnimals> zoos = new HashSet<>();

    // Constructors

    public Animal(String animaltype, Set<ZooAnimals> zoos) {
        this.animaltype = animaltype;
        this.zoos = zoos;
    }

    public Animal() {
    }
    // Getters and Setters

    public Set<ZooAnimals> getZoos() {
        return zoos;
    }

    public void setZoos(Set<ZooAnimals> zoos) {
        this.zoos = zoos;
    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }
}
