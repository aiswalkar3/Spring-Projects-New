package com.EECS.Persistence.PersistenceDemo.Entities.Inheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Outfit {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Humanoid humanoid;

    private String hat;
    private String gloves;
    private String shoes;
    private String legs;
    private String top;

    //getters and setters
}
