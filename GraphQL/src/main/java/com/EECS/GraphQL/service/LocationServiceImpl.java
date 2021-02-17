package com.EECS.GraphQL.service;

import com.EECS.GraphQL.entity.Location;
import com.EECS.GraphQL.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{
    LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository)
    {
        this.locationRepository = locationRepository;
    }

    public List<Location> retrieveLocations()
    {
        List<Location> result = (List<Location>)locationRepository.findAll();
        return result;
    }
}
