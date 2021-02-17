package com.EECS.PersistenceDemoDTO.Entities;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;

    @Column(name = "address_full", length = 500)
    private String address;
    private LocalDateTime deliveryTime;

    @Type(type = "yes_no")
    private Boolean completed;

    //often good to have lazy fetch for collection attributes
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
    List<Plant> listPlants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public List<Plant> getListPlants() {
        return listPlants;
    }

    public void setListPlants(List<Plant> listPlants) {
        this.listPlants = listPlants;
    }
}
