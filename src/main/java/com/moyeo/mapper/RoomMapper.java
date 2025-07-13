package com.moyeo.mapper;

import com.moyeo.VO.RoomVO;
import com.moyeo.dto.RoomUserMapDTO;
import com.moyeo.entity.RoomEntity;
import com.moyeo.entity.RoomPasswordEntity;
import com.moyeo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {
    void insertRoom(RoomEntity entity);
    void insertRoomPassword(RoomPasswordEntity entity);
    void insertUserInfo(UserEntity userEntity);
    void insertRoomUserMap(RoomUserMapDTO roomUserMapDTO);
    RoomVO selectRoomWithUser(Long roomId);
}
