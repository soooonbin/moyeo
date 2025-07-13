package com.moyeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoomUserMapDTO {
    private Long roomId;
    private Long userId;
}
