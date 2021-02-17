package com.EECS.Persistence.PersistenceDemo.Entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//@Embeddable
public class PersonPK implements Serializable {
    private int heightCm;
    private String sockColor;

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

    @Override
    public boolean equals(Object other)
    {
        if(this == other)
            return true;

        if(other == null || this.getClass() != other.getClass())
        {
            return false;
        }

        PersonPK personPK = (PersonPK)other;
        return heightCm == personPK.heightCm && sockColor.equals(personPK.sockColor);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(heightCm, sockColor);
    }

}
