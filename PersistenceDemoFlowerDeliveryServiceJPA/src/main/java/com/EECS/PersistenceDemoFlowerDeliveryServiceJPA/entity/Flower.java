package com.EECS.PersistenceDemoFlowerDeliveryServiceJPA.entity;

import javax.persistence.Entity;

@Entity
public class Flower extends Plant{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
