package atkinson.ashton.vehicleinventory.Repositories;

import atkinson.ashton.vehicleinventory.Models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    Vehicle save(Vehicle vehicle);

    Vehicle deleteVehicleById(String id);

    Vehicle findVehicleById(String id);

    Vehicle findVehicleByStockNumber(String stock);






}
