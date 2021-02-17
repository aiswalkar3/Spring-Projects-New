package com.EECS.PersistenceDataSource.PersistenceDataSource.controller;


import com.EECS.PersistenceDataSource.PersistenceDataSource.entity.Plant;
import com.EECS.PersistenceDataSource.PersistenceDataSource.service.PlantService;
import com.EECS.PersistenceDataSource.PersistenceDataSource.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id)
    {
        return plantService.deliveryCompleted(id);
    }

    @GetMapping("/under-price/{price}")
    @JsonView(Views.Public.class)
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price)
    {
        return plantService.findPlantsBelowPrice(price);
    }
}
