package br.com.systemhotel.dto;

import br.com.systemhotel.entity.Room;


public record CreateRoomDTO(

        Integer numero,

        Integer diaria,

        Room.StatusQuarto status
) {}
