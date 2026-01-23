package br.com.systemhotel.controller;

import br.com.systemhotel.dto.CreateRoomDTO;
import br.com.systemhotel.dto.RoomResponseDTO;
import br.com.systemhotel.entity.Room;
import br.com.systemhotel.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quartos")
public class AdminRoomController {

    private final RoomService roomService;

    @Autowired
    public AdminRoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public RoomResponseDTO create(@Valid @RequestBody CreateRoomDTO dto) {
        return roomService.createRoom(dto);
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<Room> buscarPorNumero(@PathVariable Integer numero) {
        return roomService.findByNumero(numero)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }



}
