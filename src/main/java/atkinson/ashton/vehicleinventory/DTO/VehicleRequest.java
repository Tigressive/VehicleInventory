package atkinson.ashton.vehicleinventory.DTO;


import atkinson.ashton.vehicleinventory.Models.Image;
import atkinson.ashton.vehicleinventory.Models.Vehicle;
import atkinson.ashton.vehicleinventory.Models.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {

    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "date")
    Date inDate;

    String make;

    String model;

    String vin;

    String stockNumber;

    float msrp;

    float sellingPrice;

    float invoicePrice;

    float holdbackPrice;

    float miscPriceOne;

    float miscPriceTwo;

    float miscPriceThree;

    int mileage;

    int year;

    String exColor;

    String exColorCode;

    String intColor;

    String intColorCode;

    String trim;


    List<Image> dealerImages = new ArrayList<>();


    List<Image> appraisalImages = new ArrayList<>();

    String reconComment;

    String commentOne;

    String commentTwo;

    String commentThree;

    String commentFour;

    String commentFive;


    public Vehicle getVehicle(){
        return new Vehicle(make, model, vin, year, sellingPrice, msrp, mileage);
    }

}
