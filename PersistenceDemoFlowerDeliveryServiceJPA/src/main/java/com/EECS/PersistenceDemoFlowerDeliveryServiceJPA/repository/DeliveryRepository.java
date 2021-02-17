package com.EECS.PersistenceDemoFlowerDeliveryServiceJPA.repository;

import com.EECS.PersistenceDemoFlowerDeliveryServiceJPA.entity.Delivery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery)
    {
        if(entityManager.find(Delivery.class,delivery.getId()) == null)
        {
            entityManager.persist(delivery);
        }
        else
        {
            entityManager.merge(delivery);
        }
    }

    public Delivery find(Long id)
    {
        return entityManager.find(Delivery.class,id);
    }

    public Delivery merge(Delivery delivery)
    {
        return entityManager.merge(delivery);
    }

    public void delete(Long id)
    {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }

}
