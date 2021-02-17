package com.EECS.RESTAPIDemo.Repository;

import com.EECS.RESTAPIDemo.Entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location,Long> {
}
