package com.EECS.GraphQLDemo.resolver;

import com.EECS.GraphQLDemo.entity.Dog;
import com.EECS.GraphQLDemo.exception.DogNotFoundException;
import com.EECS.GraphQLDemo.repository.DogDataRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    DogDataRepository dogDataRepository;

    public Query(DogDataRepository dogDataRepository)
    {
        this.dogDataRepository = dogDataRepository;
    }

    public Iterable<Dog> findAllDogs()
    {
        return dogDataRepository.findAll();
    }

    public Dog findDogById(Long id)
    {
        Optional<Dog> optionalDog =  dogDataRepository.findById(id);
        if(optionalDog.isPresent()){
            return optionalDog.get();
        }
        else
        {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
