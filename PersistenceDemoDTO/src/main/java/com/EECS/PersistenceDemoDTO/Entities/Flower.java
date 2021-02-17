package com.EECS.PersistenceDemoDTO.Entities;

import javax.persistence.Entity;

@Entity(name = "flower")
public class Flower extends Plant{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
