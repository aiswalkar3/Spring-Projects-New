package com.EECS.RESTAPIDemoNew.Web;

import com.EECS.RESTAPIDemoNew.Entity.Dog;
import com.EECS.RESTAPIDemoNew.Service.DogService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
                @ApiResponse(responseCode = "400", description = "This is a bad request, please follow the API documentation for proper request format."),
                @ApiResponse(responseCode = "401", description = "Due to security constraints, your access request cannot be authorized."),
                @ApiResponse(responseCode = "500", description = "Server is down. Please make sure Location microservice is running.")

        })
public class DogController {
    public DogService dogService;

    public DogController(DogService dogService)
    {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> retrieveDogs()
    {
        return new ResponseEntity<List<Dog>>(dogService.retrieveDogs(), HttpStatus.OK);
    }

    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> retrieveDogBreeds()
    {
        return new ResponseEntity<List<String>>(dogService.retrieveDogBreeds(), HttpStatus.OK);
    }

    //for request of type http://localhost:8080/dogs/1/breed/
    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> retrieveDogBreedByIdPathVariable(@PathVariable Long id)
    {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    //for request of type http://localhost:8080/dogs/breed?id=1
    @GetMapping("/dogs/breed")
    public ResponseEntity<String> retrieveDogBreedByIdRequestParam(@RequestParam(value = "id") Long id)
    {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> retrieveDogNames()
    {
        return new ResponseEntity<List<String>>(dogService.retrieveDogNames(), HttpStatus.OK);
    }
}
