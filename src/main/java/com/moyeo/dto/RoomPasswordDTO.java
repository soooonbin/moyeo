package com.moyeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoomPasswordDTO {
    private String firstWord;
    private String secondWord;
    private String thirdWord;
}
