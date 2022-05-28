package atkinson.ashton.vehicleinventory.Repositories;

import atkinson.ashton.vehicleinventory.Models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, String> {
    List<Image> findByVehicle_Id(String id);




}
