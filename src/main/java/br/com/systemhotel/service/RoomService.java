package br.com.systemhotel.service;

import br.com.systemhotel.dto.CreateRoomDTO;
import br.com.systemhotel.dto.RoomResponseDTO;
import br.com.systemhotel.entity.Room;
import br.com.systemhotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomResponseDTO createRoom(CreateRoomDTO dto) {

        if (roomRepository.existsByNumero(dto.numero())) {
            throw new IllegalStateException("Este quarto " + dto.numero() + " já existe!");
        }
                Room room = new Room(dto);
                roomRepository.save(room);
                return new RoomResponseDTO(room);
    }

    public Optional<Room> findByNumero(Integer numero) {
        return roomRepository.findByNumero(numero);
    }
}
