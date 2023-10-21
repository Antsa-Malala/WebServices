package WebServices.TP1.controller;

import WebServices.TP1.model.Vehicle;
import WebServices.TP1.repository.TripRepository;
import WebServices.TP1.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("apiVehicle")
@RestController
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    TripRepository tripRepository;

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    @GetMapping("/vehicle/{id}")
    public Optional<Vehicle> vehicleById(@PathVariable  String id){
        return vehicleRepository.findById(id);
    }

    @PostMapping("/vehicle")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    @PutMapping("/vehicle/{id}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable String id) throws Exception{
        if(vehicleRepository.existsById(id)){
            vehicle.setId(id);
            return vehicleRepository.save(vehicle);
        }else{
            throw new Exception("Error: No vehicle matches with the given id");
        }
    }

    @DeleteMapping("/vehicle/{id}")
    public void deleteVehicle(@PathVariable String id) throws Exception{
        Optional<Vehicle> temp = vehicleById(id);
        if(temp.isPresent()){
            Vehicle vehicle = temp.get();
            if(tripRepository.findByVehicle(vehicle.getId()).size() > 0){
                throw new Exception("Error: Some trips are linked with this vehicle");
            }
            vehicleRepository.deleteById(id);
        } else {
            throw new Exception("No vehicle matches with the given id");
        }
    }
}
