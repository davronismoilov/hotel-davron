package uz.pdp.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hotel.entity.Hotel;
import uz.pdp.hotel.servvice.HotelService;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/hotel")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(hotelService.getAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(hotelService.getById(id));
    }
    @PostMapping
    public HttpEntity<?> save(@RequestBody Hotel hotel){
        return ResponseEntity.ok(hotelService.save(hotel));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> save(@PathVariable Long id,@RequestBody Hotel hotel){
        return ResponseEntity.ok(hotelService.update(id,hotel));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(hotelService.delete(id));
    }

}
