package com.EECS.Persistence.PersistenceDemo.Entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@IdClass(value = PersonPK.class)
public class Person {


    //@EmbeddedId
    //private PersonPK personPk;
    @Id
    private int heightCm;

    @Id
    private String sockColor;

    public PersonPK getId()
    {
        PersonPK id = new PersonPK();
        id.setHeightCm(heightCm);
        id.setSockColor(sockColor);
        return id;
    }

    public void setId(PersonPK id)
    {
        this.heightCm = id.getHeightCm();
        this.sockColor = id.getSockColor();
    }

    @Type(type = "nstring")
    private String name;
    private int age;
    @Column(name = "composer", length = 512)
    private String favoriteComposer;

    /*
    public PersonPK getPersonPk() {
        return personPk;
    }

    public void setPersonPk(PersonPK personPk) {
        this.personPk = personPk;
    }
    */


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteComposer() {
        return favoriteComposer;
    }

    public void setFavoriteComposer(String favoriteComposer) {
        this.favoriteComposer = favoriteComposer;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public String getSockColor() {
        return sockColor;
    }

    public void setSockColor(String sockColor) {
        this.sockColor = sockColor;
    }
}
