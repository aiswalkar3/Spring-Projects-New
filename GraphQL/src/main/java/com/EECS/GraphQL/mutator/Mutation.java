package com.EECS.GraphQL.mutator;

import com.EECS.GraphQL.entity.Location;
import com.EECS.GraphQL.exception.LocationNotFoundException;
import com.EECS.GraphQL.repository.LocationRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private LocationRepository locationRepository;

    public Mutation(LocationRepository locationRepository)
    {
        this.locationRepository = locationRepository;
    }

    public Location newLocation(String name, String address){
        Location newLocation = new Location(name, address);
        locationRepository.save(newLocation);
        return newLocation;
    }

    public boolean deleteLocation(Long id)
    {
        locationRepository.deleteById(id);
        return true;
    }

    public Location updateLocationName(String newName, Long id)
    {
        Optional<Location> optionalLocation = locationRepository.findById(id);

        if(optionalLocation.isPresent())
        {
            Location location = optionalLocation.get();
            location.setName(newName);
            locationRepository.save(location);
            return location;
        }
        else{
            throw new LocationNotFoundException("Location not found",id);
        }
    }
}
