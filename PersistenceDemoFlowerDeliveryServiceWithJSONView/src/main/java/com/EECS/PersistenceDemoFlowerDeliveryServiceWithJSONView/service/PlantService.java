package com.EECS.PersistenceDemoFlowerDeliveryServiceWithJSONView.service;


import com.EECS.PersistenceDemoFlowerDeliveryServiceWithJSONView.entity.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name)
    {
        return new Plant();
    }

    public void consumePlant(Plant plant)
    {

    }
}
