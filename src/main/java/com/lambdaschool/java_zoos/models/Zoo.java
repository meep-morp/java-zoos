package com.lambdaschool.java_zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "zoos")
public class Zoo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    private String zooname;

    @OneToMany(mappedBy = "zoo",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "zoo",
            allowSetters = true)
    private Set<ZooAnimals> animals = new HashSet<>();

    @OneToMany(mappedBy = "zoo",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private List<Telephone> telephones = new ArrayList<>();
    // Constructors

    public Zoo(String zooname, Set<ZooAnimals> animals, List<Telephone> telephones) {
        this.zooname = zooname;
        this.animals = animals;
        this.telephones = telephones;
    }

    public Zoo() {
    }

    // Getters and Setters

    public Set<ZooAnimals> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<ZooAnimals> animals) {
        this.animals = animals;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }
}
