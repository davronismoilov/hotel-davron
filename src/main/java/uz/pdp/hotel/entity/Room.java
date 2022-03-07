package uz.pdp.hotel.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames ={"number","hotel_id"}))
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int number;

    byte floor;

    double size;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    Hotel hotel;

    public Room(int number, byte floor, double size, Hotel hotel) {
        this.number = number;
        this.floor = floor;
        this.size = size;
        this.hotel = hotel;
    }
}
