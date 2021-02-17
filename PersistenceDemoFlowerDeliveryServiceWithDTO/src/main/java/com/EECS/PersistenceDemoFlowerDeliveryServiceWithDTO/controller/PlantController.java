package com.EECS.PersistenceDemoFlowerDeliveryServiceWithDTO.controller;

import com.EECS.PersistenceDemoFlowerDeliveryServiceWithDTO.DTO.PlantDTO;
import com.EECS.PersistenceDemoFlowerDeliveryServiceWithDTO.entity.Plant;
import com.EECS.PersistenceDemoFlowerDeliveryServiceWithDTO.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    public PlantDTO getPlantDTO(String name)
    {
        Plant plant = plantService.getPlantByName(name);
        return convertEntityIntoDTO(plant);
    }

    @PostMapping
    public void consumePlant(@RequestBody PlantDTO plantDTO)
    {
        plantService.consumePlant(convertPlantDTOToEntity(plantDTO));
    }

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

}
