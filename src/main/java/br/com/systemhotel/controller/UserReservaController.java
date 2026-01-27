package br.com.systemhotel.controller;

import br.com.systemhotel.dto.CreateReservaDTO;
import br.com.systemhotel.dto.ReservaResponseDTO;
import br.com.systemhotel.entity.Reserva;
import br.com.systemhotel.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reservas")
public class UserReservaController {

    private final ReservaService reservaService;

    @Autowired
    public UserReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }


    @PostMapping
    public ReservaResponseDTO createReserva(@Valid @RequestBody CreateReservaDTO dto) {
        return reservaService.createReserva(dto);
    }

    @GetMapping("/disponibilidade")
    public ResponseEntity<Map<String,Boolean>> checarDisponibilidade(
            @RequestParam Long quartoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut) {
        Map<String, Boolean> response = new HashMap<>();

        boolean disponivel = reservaService.quartoDisponivel(quartoId, checkIn, checkOut);
        if (checkOut.isBefore(checkIn)) {
            response.put("disponivel", false);
        } else {
            response.put("disponivel", disponivel);
        }


        return ResponseEntity.ok(response);
    }

    @GetMapping("/cliente/verificar")
    public ResponseEntity<Map<String,Boolean>> checkReservaAtiva(@RequestParam Long clienteId) {
        Map<String, Boolean> response = new HashMap<>();
        boolean reservaAtiva = reservaService.clienteComReserva(clienteId);
        response.put("temReserva", reservaAtiva);
        return ResponseEntity.ok(response);
    }
}
