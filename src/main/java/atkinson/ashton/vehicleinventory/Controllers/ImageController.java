package atkinson.ashton.vehicleinventory.Controllers;


import atkinson.ashton.vehicleinventory.Models.Image;
import atkinson.ashton.vehicleinventory.Models.Vehicle;
import atkinson.ashton.vehicleinventory.Repositories.ImageRepository;
import atkinson.ashton.vehicleinventory.Repositories.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        for (MultipartFile multipart: multipartFile) {
            Image image = new Image();
            image.setImageContent(multipart.getBytes());
            image.setFileName(multipart.getName());
            image.setVehicle(vehicle);
            image.setSize(multipart.getSize());
            vehicle.getAppraisalImages().add(image);
            imageRepository.save(image);
        }


        vehicleRepository.save(vehicle);



    }

    @GetMapping("/getImages/{vehicleId}")
    public List<byte[]> getVehicleImages(@PathVariable String vehicleId) {

        List<byte[]> imageContent = new ArrayList<>();

        List<Image> vehicleImages = imageRepository.findByVehicle_Id(vehicleId);

        for (Image image: vehicleImages) {
            System.out.println(image.getImageContent());
            imageContent.add(image.getImageContent());

        }



        return imageContent;







    }

}
