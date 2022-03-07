package uz.pdp.hotel.payload;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.pdp.hotel.entity.Hotel;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomDTO {
    int number;

    byte floor;

    double size;

    Long hotelId;

}
