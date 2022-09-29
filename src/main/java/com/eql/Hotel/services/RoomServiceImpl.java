package com.eql.Hotel.services;

import com.eql.Hotel.dto.RoomDto;
import com.eql.Hotel.models.Room;
import com.eql.Hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void saveRoom(RoomDto roomDto) {

    }

    @Override
    public boolean reservingRoom(Long id) {
        Room room = roomRepository.getReferenceById(id);

        room.setOccupied(true);
        return room.isOccupied();
    }

    @Override
    public List<RoomDto> findAllRooms() {
        List<Room> allRooms = roomRepository.findAll();
        return allRooms.stream().map(room -> mapToRoomDto(room)).collect(Collectors.toList());
    }

    @Override
    public void getRoomDetails() {
    }

    private RoomDto mapToRoomDto(Room room) {
        return new RoomDto();
    }
}
