package WebServices.TP1.controller;


import WebServices.TP1.model.Trip;
import WebServices.TP1.model.Vehicle;
import WebServices.TP1.repository.TripRepository;
import WebServices.TP1.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("apiTrip")
@RestController
public class TripController {
    @Autowired
    TripRepository tripRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    // We have to insert the data of the vehicle here, we get it by the id avy any anaty collection "trip"
    @GetMapping("/trips")
    public List<Trip> allTrips(){
        List<Trip> temp = tripRepository.findAll();
        for(Trip trip : temp){
            Optional<Vehicle> vehicle_temp = vehicleRepository.findById(trip.getVehicle_id());
            if(vehicle_temp.isPresent()){
                trip.setMain_vehicle(vehicle_temp.get());
            }
        }
        return temp;
    }

    @GetMapping("/trip/{id}")
    public Trip tripById(@PathVariable String id){
        Optional<Trip> temp = tripRepository.findById(id);
        Trip trip = null;
        if(temp.isPresent()){
            trip = temp.get();
            Optional<Vehicle> vehicleTemp = vehicleRepository.findById(trip.getVehicle_id());
            if(vehicleTemp.isPresent()) trip.setMain_vehicle(vehicleTemp.get());
        }
        return trip;
    }

    @PostMapping("/trip")
    public Trip createTrip(@RequestBody Trip trip) throws Exception{
        Trip temp = tripRepository.save(trip);
        if(vehicleRepository.existsById(temp.getVehicle_id())){
            Optional<Vehicle> vehicle = vehicleRepository.findById(temp.getVehicle_id());
            if(vehicle.isPresent()) temp.setMain_vehicle(vehicle.get());
            return temp;
        }else{
            throw new Exception("Error: No vehicle matches with the vehicle_id given");
        }
    }

    @PutMapping("/trip/{id}")
    public Trip updateTrip(@RequestBody Trip trip, @PathVariable String id) throws Exception{
        if(tripRepository.existsById(id)){
            trip.setId(id);
            return tripRepository.save(trip);
        } else{
            throw new Exception("ERror: No trip matches with the given id");
        }
    }

    @DeleteMapping("/trip/{id}")
    public void deleteTrip(@PathVariable String id){
        tripRepository.deleteById(id);
    }

    // Just a test of a method to return all trips linked with a certain vehicles
    @GetMapping("/trips_vehicle/{idVehicle}")
    public List<Trip> tripByVehicle(@PathVariable String idVehicle){
        return tripRepository.findByVehicle(idVehicle);
    }

}
