package uz.pdp.hotel.servvice.base;

import org.springframework.stereotype.Service;
import uz.pdp.hotel.payload.ApiResponse;

@Service
public interface BaseService<T> {

    ApiResponse save(T t);

    ApiResponse getAll();

    ApiResponse getById(Long id);

    ApiResponse update(Long id,T t);

    ApiResponse delete(Long id);
}
