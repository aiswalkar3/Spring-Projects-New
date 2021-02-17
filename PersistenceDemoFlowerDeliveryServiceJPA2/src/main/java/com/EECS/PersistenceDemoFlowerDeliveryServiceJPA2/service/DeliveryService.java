package com.EECS.PersistenceDemoFlowerDeliveryServiceJPA2.service;

import com.EECS.PersistenceDemoFlowerDeliveryServiceJPA2.entity.Delivery;
import com.EECS.PersistenceDemoFlowerDeliveryServiceJPA2.repository.DeliveryRepository;
import com.EECS.PersistenceDemoFlowerDeliveryServiceJPA2.repository.RecipientAndPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery)
    {
        delivery.getPlantList().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public RecipientAndPrice getBill(Long deliveryId)
    {
        return deliveryRepository.getRecipientAndPrice(deliveryId);
    }

    public List<Delivery> getDeliveriesByName(String name)
    {
        return deliveryRepository.getDeliveriesByName(name);
    }
}
