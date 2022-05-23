package atkinson.ashton.vehicleinventory.DTO;


import atkinson.ashton.vehicleinventory.Models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {

    Date inDate;



    public Vehicle getVehicle(Date inDate) {
        return new Vehicle(inDate);
    }
}
