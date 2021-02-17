package com.EECS.RESTAPIDemoNew.Service;

import com.EECS.RESTAPIDemoNew.Entity.Dog;
import com.EECS.RESTAPIDemoNew.Repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService{
    DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository)
    {
        this.dogRepository = dogRepository;
    }

    public List<Dog> retrieveDogs()
    {
        return (List<Dog>)dogRepository.findAll();
    }

    public List<String> retrieveDogBreeds()
    {
        return dogRepository.findAllBreeds();
    }

    public String retrieveDogBreedById(Long id)
    {
        //return dogRepository.findBreedById(id);
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    public List<String> retrieveDogNames()
    {
        return dogRepository.findAllNames();
    }
}
