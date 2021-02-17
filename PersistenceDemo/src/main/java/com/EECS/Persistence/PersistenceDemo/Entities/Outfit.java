package com.EECS.Persistence.PersistenceDemo.Entities;

import javax.persistence.*;

@Entity
public class Outfit {
    @Id
    @GeneratedValue
    private Long id;
    private String hat;
    private String gloves;
    private String shoes;
    private String legs;
    private String top;

    @OneToOne
    @JoinColumn(name = "outfit_column")
    Outfit outfit;

    @OneToOne
    Person person;

    public String getHat() {
        return hat;
    }

    public void setHat(String hat) {
        this.hat = hat;
    }

    public String getGloves() {
        return gloves;
    }

    public void setGloves(String gloves) {
        this.gloves = gloves;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }
}
