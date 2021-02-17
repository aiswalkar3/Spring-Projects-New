package com.EECS.RESTAPIDemo.Web;

import com.EECS.RESTAPIDemo.Entity.Location;
import com.EECS.RESTAPIDemo.Service.LocationService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "This is a bad request, please follow the API documentation for proper request format."),
        @ApiResponse(responseCode = "401", description = "Due to security constraints, your access request cannot be authorized."),
        @ApiResponse(responseCode = "500", description = "Server is down. Please make sure Location microservice is running.")
})
public class LocationController {
    private LocationService locationService;

    @Autowired
    public void LocationController(LocationService locationService)
    {
        this.locationService = locationService;
    }

    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocations()
    {
        List<Location> list = locationService.retrieveLocations();
        return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable("id") long id)
    {
        return new ResponseEntity<Location>(locationService.retrieveLocation(id), HttpStatus.OK);
    }
}
