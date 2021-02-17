package com.EECS.RESTAPIDemoNew.Service;

import com.EECS.RESTAPIDemoNew.Entity.Dog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();
    List<String> retrieveDogBreeds();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
}
