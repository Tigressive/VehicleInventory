package atkinson.ashton.vehicleinventory.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import atkinson.ashton.vehicleinventory.Models.Images;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    String id;

    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "date")
    Date inDate;

    String make;

    String model;

    String vin;

    String stockNumber;

    float mrsp;

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

    @OneToMany
    List<Images> imagesList = new ArrayList<>();

    String reconComment;

    String commentOne;

    String commentTwo;

    String commentThree;

    String commentFour;

    String commentFive;













}
