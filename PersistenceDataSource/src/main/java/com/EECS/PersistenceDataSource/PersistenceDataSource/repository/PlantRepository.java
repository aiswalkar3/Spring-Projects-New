package com.EECS.PersistenceDataSource.PersistenceDataSource.repository;


import com.EECS.PersistenceDataSource.PersistenceDataSource.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    //check if plant by this id exists where delivery has been completed
    public Boolean existsPlantByIdAndDeliveryCompleted(Long id, Boolean delivered);

    /*JPQL approach*/
    @Query("select p.delivery.completed from Plant p where p.id = :plantId")
    public Boolean deliveryCompleted(@Param("plantId") Long plantId);

    /*Projection approach*/
    @Query("select new java.lang.Boolean(p.delivery.completed) from Plant p where p.id = :plantId")
    public Boolean deliveryCompletedBoolean(@Param("plantId") Long plantId);

    @Query("select p from Plant p where p.price < :amount")
    public List<Plant> findPlantsLessThan(BigDecimal amount);
}
