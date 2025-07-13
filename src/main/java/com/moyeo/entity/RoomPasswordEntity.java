package com.moyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomPasswordEntity {
    private Long roomId;
    private String firstWord;
    private String secondWord;
    private String thirdWord;
}
