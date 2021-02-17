package com.EECS.PersistenceDataSource.PersistenceDataSource.DAO;

import java.math.BigDecimal;

public class CandyData {
    private Long id;
    private String name;
    private BigDecimal price;

    public CandyData(String name, BigDecimal price)
    {
        this.name = name;
        this.price = price;
    }

    public CandyData()
    {

    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}