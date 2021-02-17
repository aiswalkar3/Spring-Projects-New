package com.EECS.GraphQLDemo.mutator;

import com.EECS.GraphQLDemo.entity.Dog;
import com.EECS.GraphQLDemo.exception.BreedNotFoundException;
import com.EECS.GraphQLDemo.exception.DogNotFoundException;
import com.EECS.GraphQLDemo.repository.DogDataRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogDataRepository dogDataRepository;

    public Mutation(DogDataRepository dogDataRepository)
    {
        this.dogDataRepository = dogDataRepository;
    }

    public boolean deleteDogBreed(String breed)
    {
       boolean deleted = false;

        Iterable<Dog> allDogList = dogDataRepository.findAll();

        for(Dog dog:allDogList)
        {
            if(dog.getBreed().equals(breed))
            {
                dogDataRepository.delete(dog);
                deleted = true;
            }
        }

        if(!deleted)
        {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }

        return deleted;
    }

    public Dog updateDogName(String newName, Long id)
    {
        Optional<Dog> optionalDog = dogDataRepository.findById(id);

        if(optionalDog.isPresent())
        {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogDataRepository.save(dog);
            return dog;
        }
        else
        {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
