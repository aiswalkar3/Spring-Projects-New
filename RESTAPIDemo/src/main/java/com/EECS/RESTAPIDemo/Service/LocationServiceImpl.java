package com.EECS.RESTAPIDemo.Service;

import com.EECS.RESTAPIDemo.Entity.Location;
import com.EECS.RESTAPIDemo.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{
    //@Autowired
    LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository)
    {
        this.locationRepository = locationRepository;
    }

    public List<Location> retrieveLocations()
    {
        return (List<Location>)locationRepository.findAll();
    }

    public Location retrieveLocation(long id)
    {
        Optional<Location> locationOptional = locationRepository.findById(id);

        if(locationOptional.isPresent())
        {
            return locationOptional.get();
        }
        else{
            throw new RuntimeException("Location not found");
        }
    }
}
