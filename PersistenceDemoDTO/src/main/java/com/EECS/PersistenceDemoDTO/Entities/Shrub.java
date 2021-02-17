package com.EECS.PersistenceDemoDTO.Entities;

import javax.persistence.Entity;

@Entity(name = "shrub")
public class Shrub extends Plant{
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
