package com.moyeo.service;

import com.moyeo.VO.RoomVO;
import com.moyeo.dto.RoomDTO;

public interface RoomService {
    Long createRoom(RoomDTO dto);
    RoomVO getRoom(Long id);
}
