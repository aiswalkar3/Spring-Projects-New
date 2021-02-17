package com.EECS.PersistenceDemoFlowerDeliveryServiceJPA2.repository;


import com.EECS.PersistenceDemoFlowerDeliveryServiceJPA2.entity.Delivery;
import com.EECS.PersistenceDemoFlowerDeliveryServiceJPA2.entity.Plant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery)
    {
        if(delivery.getId() == null || delivery.getId() < 0) {
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

    public List<Delivery> getDeliveriesByName(String name)
    {
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public RecipientAndPrice getRecipientAndPrice(Long deliveryId)
    {
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery<RecipientAndPrice> query = criteriaBuilder.createQuery(RecipientAndPrice.class);
       Root<Plant> plant = query.from(Plant.class);
       query.select(criteriaBuilder.construct(RecipientAndPrice.class,
               plant.get("delivery").get("name"), criteriaBuilder.sum(plant.get("price"))))
               .where(criteriaBuilder.equal(plant.get("delivery").get("id"), deliveryId));
       return entityManager.createQuery(query).getSingleResult();
    }
}
