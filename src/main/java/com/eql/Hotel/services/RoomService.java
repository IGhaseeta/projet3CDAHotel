package com.eql.Hotel.services;


import com.eql.Hotel.dto.RoomDto;
import com.eql.Hotel.models.Room;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface RoomService {

    Room saveRoom(MultipartFile multipartFile, RoomDto roomDto); //Créer un objet d'une classe de spring pour importer les photos

    Room updateRoom(MultipartFile multipartFile, RoomDto roomDto);

    void deleteById(long id);

    void enableById(long id);

    RoomDto getById(long id);

    List<RoomDto> findAll();


//    void getRoomDetails();
//    boolean reservingRoom(Long id);
}
