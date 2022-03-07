package uz.pdp.hotel.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String name;


    public Hotel setName(String name) {
        this.name = name;
        return this;
    }
}
