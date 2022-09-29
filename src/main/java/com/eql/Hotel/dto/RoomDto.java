package com.eql.Hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomDto {

    private Long id;
    private String name;
    private String ImagePath = "/images/room" + id + ".jpg";
    private String description;


}
