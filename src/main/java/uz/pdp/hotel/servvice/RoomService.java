package uz.pdp.hotel.servvice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.hotel.entity.Hotel;
import uz.pdp.hotel.entity.Room;
import uz.pdp.hotel.payload.ApiResponse;
import uz.pdp.hotel.payload.RoomDTO;
import uz.pdp.hotel.repository.HotelRepository;
import uz.pdp.hotel.repository.RoomRepository;
import uz.pdp.hotel.servvice.base.BaseService;

import java.util.Optional;

import static uz.pdp.hotel.utills.Constant.*;

@Service
@RequiredArgsConstructor
public class RoomService implements BaseService<RoomDTO> {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Override
    public ApiResponse save(RoomDTO roomDTO) {
        if (roomRepository.existsByNumberAndHotelId(roomDTO.getNumber(), roomDTO.getHotelId()))
            return new ApiResponse(ALREADY_EXIST, false);
        return new ApiResponse(SUCCESS, true, roomRepository.save(new Room(
                roomDTO.getNumber(),
                roomDTO.getFloor(),
                roomDTO.getSize(),
                hotelRepository.findById(roomDTO.getHotelId()).orElse(null)
        )));
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse(SUCCESS, true, roomRepository.findAll());
    }

    @Override
    public ApiResponse getById(Long id) {
        return new ApiResponse(SUCCESS, true, roomRepository.findById(id));
    }

    @Override
    public ApiResponse update(Long id, RoomDTO roomDTO) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        optionalRoom.ifPresent(value -> roomRepository.save(
                new Room(
                        id,
                        roomDTO.getNumber(),
                        roomDTO.getFloor(),
                        roomDTO.getSize(),
                        hotelRepository.findById(roomDTO.getHotelId()).orElse(null)
                )));
        return new ApiResponse(SUCCESS, true);
    }

    @Override
    public ApiResponse delete(Long id) {
        try {
            roomRepository.findById(id).ifPresent(roomRepository::delete);
            return new ApiResponse(SUCCESS, true);
        } catch (Exception e) {
            return new ApiResponse(NOT_FOUND, false);
        }
    }

    public ApiResponse getByHotelId(Long hotelId,Long page){
        return new ApiResponse(SUCCESS,true,roomRepository.findByHotelId(hotelId,5*(page-1),5L));
    }
}
