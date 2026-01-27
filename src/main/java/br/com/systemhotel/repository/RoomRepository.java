package br.com.systemhotel.repository;

import br.com.systemhotel.dto.RoomResponseDTO;
import br.com.systemhotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public interface RoomRepository extends JpaRepository<Room, Long> {

    boolean existsByNumero(Integer numero);

    Optional<Room> findByNumero(Integer numero);

    boolean existsById(Long id);

}
