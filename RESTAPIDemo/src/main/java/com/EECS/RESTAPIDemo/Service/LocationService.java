package com.EECS.RESTAPIDemo.Service;

import com.EECS.RESTAPIDemo.Entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> retrieveLocations();
    Location retrieveLocation(long id);
}
