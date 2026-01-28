package br.com.systemhotel.service;


import br.com.systemhotel.dto.CreateReservaDTO;
import br.com.systemhotel.dto.ReservaResponseDTO;
import br.com.systemhotel.entity.Customer;
import br.com.systemhotel.entity.Reserva;
import br.com.systemhotel.entity.Room;
import br.com.systemhotel.exception.ConflictException;
import br.com.systemhotel.repository.CustomerRepository;
import br.com.systemhotel.repository.ReservaRepository;
import br.com.systemhotel.repository.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, RoomRepository roomRepository) {
        this.reservaRepository = reservaRepository;
        this.roomRepository = roomRepository;
    }


    public boolean quartoDisponivel(Long quartoId, LocalDate checkIn, LocalDate checkOut) {
        boolean quartoReservado = reservaRepository.existsReserva(
                        quartoId,
                        checkIn,
                        checkOut);
        return !quartoReservado;
    }

    public boolean clienteComReserva(Long clienteID) {
        boolean clienteComReservaAtiva;
        if (reservaRepository.existsByClienteId(clienteID)) {
            return clienteComReservaAtiva = true;
        } else {
            return clienteComReservaAtiva = false;
        }
    }

    public ReservaResponseDTO createReserva(@Valid CreateReservaDTO dto) {
        Reserva reserva = new Reserva(dto);
        reservaRepository.save(reserva);
        return new ReservaResponseDTO(reserva);
    }

    public Reserva save (@Valid Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }


    public List<Reserva> findByQuartoIdAndCheckIn(Long quartoId, LocalDate data) {
        return reservaRepository.buscarReservaAtivaHoje(quartoId, data);
    }

    public Reserva findById(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));
    }
}
