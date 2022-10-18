package com.eql.Hotel.controller;

import com.eql.Hotel.dto.RoomDto;
import com.eql.Hotel.models.Room;
import com.eql.Hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

//    @GetMapping("/room")
//    public String bringAllRooms(Model model ) {
//        List<RoomDto> allRooms = roomService.findAllRooms();
//
//            model.addAttribute("allRooms", allRooms);
//            if (allRooms.size() == 0)
//            {  RoomDto voidRoom = new RoomDto();
//               voidRoom.setId(0L);
//               voidRoom.setName("Chambre Vide");
//               voidRoom.setImagePath("/images/roomVoid.jpg");
//               voidRoom.setDescription("Voici une chambre vide");
//               allRooms.add(voidRoom);
//            }
//
//        return "room";}

    @GetMapping("/showRoomDetails")
    public String getRoomDetails(Model model){
        model.addAttribute("roomDetails", "Room Details");
        // roomService.getRoomDetails();
        return "RoomDetails";
    }

    @GetMapping("/roomsAdmin")
    public String roomsAdmin(Model model){
        List<RoomDto> roomsDtoList = roomService.findAll();
        model.addAttribute("title", "Manage rooms");
        model.addAttribute("rooms", roomsDtoList);
        model.addAttribute("size", roomsDtoList.size());
        return "/roomsAdmin";
    }

    @GetMapping("/add-room")
    public String addRoomForm(Model model){

        model.addAttribute("room", new RoomDto());
        return "add-room";

    }

    @PostMapping("/save-room")

    public String saveRoom (@ModelAttribute("room") RoomDto roomDto,
                            @RequestParam("imageRoom") MultipartFile imageRoom, RedirectAttributes redirectAttribute)
    //stock dans l'objet room avec les parametres de imageRoom

    {
        try{
            roomService.saveRoom(imageRoom, roomDto);
            //redirect attribute affiche des message instannées
            redirectAttribute.addFlashAttribute("success", "Room added successfully !!!");
        }catch (Exception e){
            e.printStackTrace();
            redirectAttribute.addFlashAttribute("error", "Room creation failed!!!");
        }
        return "add-room";
    }



}

