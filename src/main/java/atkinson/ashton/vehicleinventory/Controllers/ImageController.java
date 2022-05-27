package atkinson.ashton.vehicleinventory.Controllers;


import atkinson.ashton.vehicleinventory.Models.Image;
import atkinson.ashton.vehicleinventory.Models.Vehicle;
import atkinson.ashton.vehicleinventory.Repositories.ImageRepository;
import atkinson.ashton.vehicleinventory.Repositories.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/image")
public class ImageController {


    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ImageRepository imageRepository;

    @PostMapping("/appraisalUpload/{vehicleId}")
    public void uploadImage(@RequestParam("image")MultipartFile[] multipartFile, @PathVariable String vehicleId) throws IOException {


        Vehicle vehicle = vehicleRepository.findVehicleById(vehicleId);

        Image image = new Image();
        for (MultipartFile multipart: multipartFile) {
            image.setImageContent(multipart.getBytes());
        }

        image.setImageContent(multipartFile.getBytes());
        image.setFileName(multipartFile.getName());

        image.setVehicle(vehicle);
        image.setSize(multipartFile.getSize());

        vehicle.getAppraisalImages().add(image);

        imageRepository.save(image);
        vehicleRepository.save(vehicle);



    }

}
