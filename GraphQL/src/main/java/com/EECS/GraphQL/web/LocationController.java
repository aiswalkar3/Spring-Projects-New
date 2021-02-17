package com.EECS.GraphQL.web;

import com.EECS.GraphQL.entity.Location;
import com.EECS.GraphQL.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    private LocationService locationService;

    public LocationController(LocationService locationService)
    {
        this.locationService = locationService;
    }

    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocations()
    {
        List<Location> locations = locationService.retrieveLocations();
        return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
    }
}
