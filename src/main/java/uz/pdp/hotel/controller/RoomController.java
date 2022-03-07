package uz.pdp.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hotel.entity.Hotel;
import uz.pdp.hotel.payload.RoomDTO;
import uz.pdp.hotel.servvice.HotelService;
import uz.pdp.hotel.servvice.RoomService;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/room")
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(roomService.getAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(roomService.getById(id));
    }
    @PostMapping
    public HttpEntity<?> save(@RequestBody RoomDTO roomDTO){
        return ResponseEntity.ok(roomService.save(roomDTO));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> save(@PathVariable Long id,@RequestBody RoomDTO roomDTO){
        return ResponseEntity.ok(roomService.update(id,roomDTO));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(roomService.delete(id));
    }


    @GetMapping("/{hotelId}/{page}")
    public HttpEntity<?> getByHotelId(@PathVariable Long hotelId,@PathVariable Long page){
        return ResponseEntity.ok(roomService.getByHotelId(hotelId,page));
    }

}
