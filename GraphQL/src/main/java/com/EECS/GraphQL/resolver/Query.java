package com.EECS.GraphQL.resolver;

import com.EECS.GraphQL.entity.Location;
import com.EECS.GraphQL.repository.LocationRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver
{
    private LocationRepository locationRepository;

    public Query(LocationRepository locationRepository)
    {
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> findAllLocations()
    {
        return locationRepository.findAll();
    }
}
