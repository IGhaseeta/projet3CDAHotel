package com.eql.Hotel.services;

import com.eql.Hotel.dto.RoomDto;
import com.eql.Hotel.models.Room;
import com.eql.Hotel.repository.RoomRepository;
import com.eql.Hotel.util.ImageUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository ;

    @Autowired
    private ImageUpload imageUpload;

    @Override
    public Room saveRoom(MultipartFile imageRoom, RoomDto roomDto) {
        try {
            Room room = new Room();
            if (imageRoom == null) {
                room.setImage(null);
            }else {
                if (imageUpload.uploadImage(imageRoom))
                {
                    System.out.println("Image uploaded successfully");
                }
                room.setImage(Base64.getEncoder().encodeToString(imageRoom.getBytes()));
            }
            room.setName(roomDto.getName());
            room.setDescription(roomDto.getDescription());
            room.setPrice(roomDto.getPrice());
            room.setActivated(true);
            room.setDeleted(false);
            return roomRepository.save(room);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Room updateRoom(MultipartFile imageRoom, RoomDto roomDto) {

      try {
          Room room = roomRepository.getReferenceById(roomDto.getId());
          if (imageRoom ==null){
              room.setImage(room.getImage());
          }
          else{
              if (imageUpload.checkExisted(imageRoom) == false){
                  System.out.println("upload to folder ");
                  imageUpload.uploadImage(imageRoom);
              }
              System.out.println("Image exists already");
              room.setImage(Base64.getEncoder().encodeToString(imageRoom.getBytes()));
          }
            room.setName(roomDto.getName());
            room.setDescription(roomDto.getDescription());
            room.setPrice(roomDto.getPrice());
            return roomRepository.save(room);

      }  catch (Exception e) {
          e.printStackTrace();
          return null;
      }
    }

    @Override
    public void deleteById(long id) {
        Room room = roomRepository.getReferenceById(id);
        room.setDeleted(true);
        room.setActivated(false);
        roomRepository.save(room);
    }

    @Override
    public void enableById(long id) {
        Room room = roomRepository.getReferenceById(id);
        room.setActivated(true);
        room.setDeleted(false);
        roomRepository.save(room);
    }

    @Override
    public RoomDto getById(long id) {
        Room room = roomRepository.getReferenceById(id);
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setName(room.getName());
        roomDto.setDescription(room.getDescription());
        roomDto.setPrice(room.getPrice());
        roomDto.setDeleted(room.isDeleted());
        roomDto.setActivated(room.isActivated());
        roomDto.setImage(room.getImage());
        return roomDto;
    }

    @Override
    public List<RoomDto> findAll() {
        List<RoomDto> roomsDtoList = new ArrayList<>();
        List<Room> roomsList = roomRepository.findAll();
        for (Room room : roomsList) {
            RoomDto roomDto = new RoomDto();
            roomDto.setId(room.getId());
            roomDto.setName(room.getName());
            roomDto.setDescription(room.getDescription());
            roomDto.setPrice(room.getPrice());
            roomDto.setImage(room.getImage());
            roomDto.setActivated(room.isActivated());
            roomDto.setDeleted(room.isDeleted());
            roomsDtoList.add(roomDto);
        }
            return roomsDtoList;
    }
}
