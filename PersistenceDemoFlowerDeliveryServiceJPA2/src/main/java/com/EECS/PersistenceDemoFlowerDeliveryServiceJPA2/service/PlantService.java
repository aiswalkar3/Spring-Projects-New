package com.EECS.PersistenceDemoFlowerDeliveryServiceJPA2.service;

import com.EECS.PersistenceDemoFlowerDeliveryServiceJPA2.entity.Plant;
import com.EECS.PersistenceDemoFlowerDeliveryServiceJPA2.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    public Long save(Plant plant)
    {
        return plantRepository.save(plant).getId();
    }

    public Boolean deliveryCompleted(Long plantId)
    {
        return plantRepository.deliveryCompletedBoolean(plantId);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price)
    {
        return plantRepository.findPlantsLessThan(price);
    }
}
