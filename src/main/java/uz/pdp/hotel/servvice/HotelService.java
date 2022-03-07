package uz.pdp.hotel.servvice;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import uz.pdp.hotel.entity.Hotel;
import uz.pdp.hotel.payload.ApiResponse;
import uz.pdp.hotel.repository.HotelRepository;
import uz.pdp.hotel.servvice.base.BaseService;

import java.util.Optional;

import static uz.pdp.hotel.utills.Constant.*;

@Service
@RequiredArgsConstructor
public class HotelService implements BaseService<Hotel> {

    private final HotelRepository hotelRepository;

    @Override
    public ApiResponse save(Hotel hotel) {
        if(hotelRepository.existsByName(hotel.getName()))return new ApiResponse(ALREADY_EXIST,false);
        return new ApiResponse(SUCCESS,true,hotelRepository.save(hotel));
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse(SUCCESS,true,hotelRepository.findAll());
    }

    @Override
    public ApiResponse getById(Long id) {
        return new ApiResponse(SUCCESS,true,hotelRepository.findById(id));
    }

    @Override
    public ApiResponse update(Long id, Hotel hotel) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        optionalHotel.ifPresent(value -> hotelRepository.save(value.setName(hotel.getName())));
        return new ApiResponse(SUCCESS,true);
    }

    @Override
    public ApiResponse delete(Long id) {
        try {
            hotelRepository.findById(id).ifPresent(hotelRepository::delete);
            return new ApiResponse(SUCCESS,true);
        }catch (Exception e){
            return new ApiResponse(NOT_FOUND,false);
        }
    }
}
