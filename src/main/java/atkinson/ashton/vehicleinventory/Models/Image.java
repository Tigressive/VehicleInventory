package atkinson.ashton.vehicleinventory.Models;


import atkinson.ashton.vehicleinventory.View.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Image {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    String id;

    String fileName;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    Vehicle vehicle;

    long size;

    @Column(nullable = true, length = 64)
    @JsonView(JsonViews.ImageView.class)
    private byte[] imageContent;


}
