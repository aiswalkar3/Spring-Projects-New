package com.EECS.Persistence.PersistenceDemo.Entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person-example1")
public class PersonNew {
    @Id
    @GeneratedValue
    private Long id;

    /*
    @OneToOne(mappedBy = "person")
    Outfit outfit;
    */

    @OneToMany(mappedBy = "person")
    private List<Outfit> outfits;

    @Type(type = "nstring")
    private String name;
    private int age;
    @Column(name = "composer", length = 512)
    private String favoriteComposer;
}
