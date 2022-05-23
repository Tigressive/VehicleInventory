package atkinson.ashton.vehicleinventory.Controllers;

import atkinson.ashton.vehicleinventory.DTO.VehicleRequest;
import atkinson.ashton.vehicleinventory.Models.Vehicle;
import atkinson.ashton.vehicleinventory.Repositories.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Slf4j
@RestController
@RequestMapping("/vehicle")
public class VehicleController {


    @Autowired
    VehicleRepository vehicleRepository;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    @Transactional(rollbackOn = Exception.class)
    public void createVehicle(@RequestBody VehicleRequest){

        Vehicle vehicle = new Vehicle();

        vehicleRepository.save(vehicle);

    }




}
