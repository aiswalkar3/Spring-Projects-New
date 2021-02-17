package com.EECS.PersistenceDemoDTO.Controller;

import com.EECS.PersistenceDemoDTO.DTO.PlantDTO;
import com.EECS.PersistenceDemoDTO.Entities.Plant;
import com.EECS.PersistenceDemoDTO.Service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    PlantService plantService;

    @GetMapping
    public PlantDTO getPlantDTO(String name)
    {
        return convertEntityToPlantDTO(plantService.getPlantByName(name));
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name)
    {
        return plantService.getPlantByName(name);
    }

    public PlantDTO convertEntityToPlantDTO(Plant plant)
    {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    public Plant convertPlantDTOToEntity(PlantDTO plantDTO)
    {
        Plant plant = new Plant();
        BeanUtils.copyProperties(plantDTO, plant);
        return plant;
    }
}
