package WebServices.TP1.repository;

import WebServices.TP1.model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TripRepository extends MongoRepository<Trip, String> {
    @Query("{vehicle_id : ?0}")
    List<Trip> findByVehicle(String vehicle_id);
}
