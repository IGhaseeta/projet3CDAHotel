package com.eql.Hotel.services;


import com.eql.Hotel.dto.RoomDto;


import java.util.List;

public interface RoomService {

    void saveRoom(RoomDto roomDto);

    boolean reservingRoom(Long id);

    List<RoomDto> findAllRooms();

    void getRoomDetails();
}
