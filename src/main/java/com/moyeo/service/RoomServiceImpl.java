package com.moyeo.service;

import com.moyeo.VO.RoomVO;
import com.moyeo.dto.RoomDTO;
import com.moyeo.dto.RoomPasswordDTO;
import com.moyeo.dto.RoomUserMapDTO;
import com.moyeo.dto.UserDTO;
import com.moyeo.entity.RoomEntity;
import com.moyeo.entity.RoomPasswordEntity;
import com.moyeo.entity.UserEntity;
import com.moyeo.mapper.RoomMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomMapper roomMapper;

    @Override
    @Transactional
    public Long createRoom(RoomDTO dto) {
        // 채팅방 정보
        RoomEntity room = new RoomEntity();
        room.setRoomNm(dto.getRoomName());
        room.setRoomTypeCd(dto.getRoomType());
        room.setRoomQnum(dto.getRoomQnum());
        room.setNumPeople(dto.getNumPeople());
        roomMapper.insertRoom(room);

        // 채팅방 패스워드 정보
        RoomPasswordEntity password = new RoomPasswordEntity();
        RoomPasswordDTO pwdDto = dto.getRoomPassword();
        password.setRoomId(room.getRoomId());
        password.setFirstWord(pwdDto.getFirstWord());
        password.setSecondWord(pwdDto.getSecondWord());
        password.setThirdWord(pwdDto.getThirdWord());
        roomMapper.insertRoomPassword(password);

        // 채팅방 사용자 정보
        UserEntity user = new UserEntity();
        UserDTO userDto = dto.getUserInfo();
        user.setUserName(userDto.getUserName());
        user.setUserImg(userDto.getUserImg());
        user.setUserColor(userDto.getUserColor());
        roomMapper.insertUserInfo(user);
        // 채팅방 - 사용자정보 매핑
        RoomUserMapDTO roomUserMapDTO = new RoomUserMapDTO(room.getRoomId(),user.getUserId());
        roomMapper.insertRoomUserMap(roomUserMapDTO);

        return room.getRoomId();
    }

    @Override
    public RoomVO getRoom(Long id) {
        System.out.println("#####paramID: " + id);
        return roomMapper.selectRoomWithUser(id);
    }
}