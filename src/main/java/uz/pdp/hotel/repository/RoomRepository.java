package uz.pdp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.hotel.entity.Hotel;
import uz.pdp.hotel.entity.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {

    @Modifying
    @Query(nativeQuery = true,value = "select * from room where hotel_id=?1 offset ?2 limit ?3")
    List<Room> findByHotelId(Long hotelId,Long offset,Long limit);

    boolean existsByNumberAndHotelId(int number, Long hotelId);
}
