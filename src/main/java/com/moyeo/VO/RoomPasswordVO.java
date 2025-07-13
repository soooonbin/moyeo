package com.moyeo.VO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomPasswordVO {
    private Long roomId;
    private String firstWord;
    private String secondWord;
    private String thirdWord;
}
