package com.eql.Hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoomDto {

    private Long id;
    private String name;
    private String image;
    private String description;
    private double price;
    private boolean isOccupied;
    private boolean isDeleted;
    private boolean isActivated;

}
