package com.moyeo.VO;

import com.moyeo.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomVO {
    private Long roomId;
    private String roomName;
    private String roomType;
    private int roomQnum;
    private UserVO userInfo;
}
