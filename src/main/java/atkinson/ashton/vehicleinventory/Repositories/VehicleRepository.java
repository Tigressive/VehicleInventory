package atkinson.ashton.vehicleinventory.Repositories;

import atkinson.ashton.vehicleinventory.Models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    Vehicle save(Vehicle vehicle);

    Vehicle deleteVehicleById(String id);







}
