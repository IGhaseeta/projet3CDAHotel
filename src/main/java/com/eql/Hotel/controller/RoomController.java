package com.eql.Hotel.controller;

import com.eql.Hotel.dto.RoomDto;
import com.eql.Hotel.models.Room;
import com.eql.Hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    RoomService roomService;
/*
    @RequestMapping(value = {"/room"}, method = RequestMethod.GET)
    public static String about() {return "room";}

 */

    @GetMapping("/room")
    public String bringAllRooms(Model model ) {
        List<RoomDto> allRooms = roomService.findAllRooms();

            model.addAttribute("allRooms", allRooms);
            if (allRooms.size() == 0)
            {  RoomDto voidRoom = new RoomDto();
               voidRoom.setId(0L);
               voidRoom.setName("Chambre Vide");
               voidRoom.setImagePath("/images/roomVoid.jpg");
               voidRoom.setDescription("Voici une chambre vide");
               allRooms.add(voidRoom);
            }

        return "room";}

    @GetMapping("/showRoomDetails")
    public String getRoomDetails(Model model){
        model.addAttribute("roomDetails", "Room Details");
        // roomService.getRoomDetails();
        return "RoomDetails";
    }
}

