package com.EECS.PersistenceDemoDTO.Service;

import com.EECS.PersistenceDemoDTO.Entities.Flower;
import com.EECS.PersistenceDemoDTO.Entities.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant();
    }
}
