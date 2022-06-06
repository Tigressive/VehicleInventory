package atkinson.ashton.vehicleinventory.Controllers;

import atkinson.ashton.vehicleinventory.DTO.VehicleRequest;
import atkinson.ashton.vehicleinventory.Models.Vehicle;
import atkinson.ashton.vehicleinventory.Repositories.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/vehicle")
public class VehicleController {


    @Autowired
    VehicleRepository vehicleRepository;

    WebClient vehicleClient = WebClient.create("http://localhost:8080");

    //Post a new vehicle
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    @Transactional(rollbackOn = Exception.class)
    public void createVehicle(@RequestBody VehicleRequest vehicleRequest) {

        Vehicle vehicle = vehicleRequest.getVehicle();

        vehicleRepository.save(vehicle);

    }


    //Patch
    @PatchMapping("/updateVehicle")
    @ResponseStatus(code = HttpStatus.OK)
    @Transactional(rollbackOn = Exception.class)
    public void updateVehicle(@RequestBody Map<String, String> body) {
        Vehicle vehicle = vehicleRepository.findVehicleById(body.get("id"));

        if(vehicle != null) {
            log.info(vehicle.toString());

            if(body.containsKey("make")){
                vehicle.setMake(body.get("make"));
            }

            if(body.containsKey("model")) {
                vehicle.setModel(body.get("model"));
            }

            if(body.containsKey("year")) {
                vehicle.setYear(Integer.parseInt(body.get("year")));
            }

            if(body.containsKey("vin")){
                vehicle.setVin(body.get("vin"));
            }

            if(body.containsKey("stockNumber")){
                String stockNumber = body.get("stockNumber");
                vehicle.setStockNumber(stockNumber);
            }

            if(body.containsKey("msrp")){
                vehicle.setMsrp(Float.parseFloat(body.get("msrp")));
            }

            if(body.containsKey("sellingPrice")){
                vehicle.setSellingPrice(Float.parseFloat(body.get("sellingPrice")));
            }

            if(body.containsKey("invoicePrice")) {
                vehicle.setInvoicePrice(Float.parseFloat(body.get("invoicePrice")));
            }

            if(body.containsKey("holdbackPrice")){
                vehicle.setHoldbackPrice(Float.parseFloat(body.get("holdbackPrice")));
            }

            if(body.containsKey("miscPriceOne")){
                vehicle.setMiscPriceOne(Float.parseFloat(body.get("miscPriceOne")));
            }

            if(body.containsKey("miscPriceTwo")){
                vehicle.setMiscPriceTwo(Float.parseFloat(body.get("miscPriceTwo")));
            }

            if(body.containsKey("miscPriceThree")){
                vehicle.setMiscPriceThree(Float.parseFloat(body.get("miscPriceThree")));
            }

            if(body.containsKey("mileage")){
                vehicle.setMileage(Integer.parseInt(body.get("mileage")));
            }

            if(body.containsKey("exColor")){
                vehicle.setExColor(body.get("exColor"));
            }

            vehicleRepository.save(vehicle);
        }
    }
}
