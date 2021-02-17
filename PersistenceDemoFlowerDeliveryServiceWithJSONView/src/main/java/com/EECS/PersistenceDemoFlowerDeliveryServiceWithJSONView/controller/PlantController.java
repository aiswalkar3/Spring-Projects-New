package com.EECS.PersistenceDemoFlowerDeliveryServiceWithJSONView.controller;


import com.EECS.PersistenceDemoFlowerDeliveryServiceWithJSONView.entity.Plant;
import com.EECS.PersistenceDemoFlowerDeliveryServiceWithJSONView.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @JsonView(Views.Public.class)
    @GetMapping
    public Plant getFilteredPlant(String name)
    {
        Plant plant = plantService.getPlantByName(name);
        return plant;
    }

    @PostMapping
    public void consumePlant(@RequestBody Plant plant)
    {
        plantService.consumePlant(plant);
    }

    /*
    public PlantDTO convertEntityIntoDTO(Plant plant)
    {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    public Plant convertPlantDTOToEntity(PlantDTO plantDTO)
    {
        Plant newPlant = new Plant();
        BeanUtils.copyProperties(plantDTO, newPlant);
        return newPlant;
    }
    */
}
