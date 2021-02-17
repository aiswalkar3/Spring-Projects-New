package com.EECS.PersistenceDataSource.PersistenceDataSource;

import com.EECS.PersistenceDataSource.PersistenceDataSource.entity.Delivery;
import com.EECS.PersistenceDataSource.PersistenceDataSource.entity.Plant;
import com.EECS.PersistenceDataSource.PersistenceDataSource.repository.PlantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersistenceDataSourceApplicationTests {
	@Autowired
	TestEntityManager entityManager;

	@Autowired
	PlantRepository plantRepository;

	public void persistPlant(Plant plant)
	{
		entityManager.persist(plant);
	}

	public void persistDelivery(Delivery delivery)
	{
		entityManager.persist(delivery);
	}

	@Test
	void testPriceLessThan() {
		Plant plantOne = new Plant();
		plantOne.setName("Petunia");
		plantOne.setPrice(BigDecimal.valueOf(3.5));
		persistPlant(plantOne);

		Plant plantTwo = new Plant();
		plantTwo.setName("Tulip");
		plantTwo.setPrice(BigDecimal.valueOf(2.5));
		persistPlant(plantTwo);

		List<Plant> plantList = plantRepository.findPlantsLessThan(BigDecimal.valueOf(3));
		assertEquals(1, plantList.size(), "Size");
		assertEquals(plantTwo.getId(), plantList.get(0).getId(), "Id");
	}

	@Test
	void testDeliveryCompleted() {
		Plant plantOne = new Plant();
		plantOne.setPrice(BigDecimal.valueOf(3.5));
		plantOne.setName("Tulip");
		persistPlant(plantOne);

		Delivery delivery = new Delivery();
		delivery.setName("Terry");
		delivery.setAddress("1234 Sesame Blvd");
		delivery.setDeliveryDateTime(LocalDateTime.now());
		persistDelivery(delivery);

		delivery.setPlantList(Arrays.asList(plantOne));
		plantOne.setDelivery(delivery);

		assertFalse(plantRepository.existsPlantByIdAndDeliveryCompleted(plantOne.getId(), true));
		delivery.setCompleted(true);
		assertTrue(plantRepository.existsPlantByIdAndDeliveryCompleted(plantOne.getId(), true));
	}
}
