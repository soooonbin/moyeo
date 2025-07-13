package com.moyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomEntity {
    private Long roomId;
    private String roomNm;
    private String roomTypeCd;
    private int roomQnum;
    private int numPeople;
}
