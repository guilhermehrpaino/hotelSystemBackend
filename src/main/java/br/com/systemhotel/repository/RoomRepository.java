package br.com.systemhotel.repository;

import br.com.systemhotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoomRepository extends JpaRepository<Room, Long> {

    boolean existsByNumero(Integer numero);

    Optional<Room> findByNumero(Integer numero);
}
