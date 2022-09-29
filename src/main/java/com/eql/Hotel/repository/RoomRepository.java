package com.eql.Hotel.repository;

import com.eql.Hotel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository <Room, Long> {

    List<Room> findAll();
}
