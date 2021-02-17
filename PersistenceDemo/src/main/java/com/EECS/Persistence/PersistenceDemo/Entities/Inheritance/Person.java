package com.EECS.Persistence.PersistenceDemo.Entities.Inheritance;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends Humanoid{
    @Type(type = "nstring")
    private String name;
    private int age;
    @Column(name = "composer", length = 512)
    private String favoriteComposer;
}
