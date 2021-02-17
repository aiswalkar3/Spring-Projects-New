package com.EECS.RESTAPIDemoNew.Repository;

import com.EECS.RESTAPIDemoNew.Entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog,Long> {
    @Query("Select id, breed from Dog where id = :id")
    String findBreedById(Long id);

    @Query("Select id, breed from Dog")
    List<String> findAllBreeds();

    @Query("Select id, name from Dog")
    List<String> findAllNames();
}
