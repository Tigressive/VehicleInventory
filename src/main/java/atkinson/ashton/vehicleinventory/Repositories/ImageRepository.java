package atkinson.ashton.vehicleinventory.Repositories;

import atkinson.ashton.vehicleinventory.Models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
