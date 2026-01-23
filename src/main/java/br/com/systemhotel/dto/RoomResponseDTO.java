package br.com.systemhotel.dto;

import br.com.systemhotel.entity.Room;

public record RoomResponseDTO(
        Long id,
        Integer numero,
        Integer diaria,
        Room.StatusQuarto status
) {

    public RoomResponseDTO(Room room) {
        this(

                room.getId(),
                room.getNumero(),
                room.getDiaria(),
                room.getStatus()
    );
    }
}
