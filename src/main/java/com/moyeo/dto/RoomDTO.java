package com.moyeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RoomDTO {
    private Long roomId;
    private RoomPasswordDTO roomPassword;  // ✅ 중첩 객체
    private String roomName;
    private String roomType;
    private int roomQnum;
    private int numPeople;
    private UserDTO userInfo;
}
