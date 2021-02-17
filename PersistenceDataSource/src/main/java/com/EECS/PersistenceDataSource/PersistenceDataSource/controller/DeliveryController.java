package com.EECS.PersistenceDataSource.PersistenceDataSource.controller;


import com.EECS.PersistenceDataSource.PersistenceDataSource.entity.Delivery;
import com.EECS.PersistenceDataSource.PersistenceDataSource.repository.RecipientAndPrice;
import com.EECS.PersistenceDataSource.PersistenceDataSource.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery)
    {
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId)
    {
        return deliveryService.getBill(deliveryId);
    }

    @GetMapping("/name")
    public List<Delivery> getDeliveriesByName(@RequestParam("name") String deliveryName)
    {
        return deliveryService.getDeliveriesByName(deliveryName);
    }
}
