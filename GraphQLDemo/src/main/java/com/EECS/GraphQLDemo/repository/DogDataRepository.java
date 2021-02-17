package com.EECS.GraphQLDemo.repository;

import com.EECS.GraphQLDemo.entity.Dog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DogDataRepository extends CrudRepository<Dog, Long> {
}
