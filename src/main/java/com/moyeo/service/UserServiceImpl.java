package com.moyeo.service;

import com.moyeo.VO.RoomVO;
import com.moyeo.VO.UserVO;
import com.moyeo.dto.RoomUserMapDTO;
import com.moyeo.entity.UserEntity;
import com.moyeo.mapper.RoomMapper;
import com.moyeo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final RoomMapper roomMapper;

    @Override
    public List<UserVO> userList(Long id){
        List<UserVO> userList = userMapper.getUserList(id);
        return userList;
    }

    @Override
    public UserVO getUserInfo(UserVO userVO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userVO.getUserId());
        userEntity.setRoomId(userVO.getRoomId());
        UserVO result = userMapper.getUserInfo(userEntity);
        return result;
    }

    @Override
    public UserVO addUserInfo(UserVO userVO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userVO.getUserName());
        userEntity.setUserColor(userVO.getUserColor());
        userEntity.setRoomId(userVO.getRoomId());
        // Img: 1~6 사이 랜덤 숫자
        int imageNumber = new Random().nextInt(6) + 1;
        userEntity.setUserImg(imageNumber);
        Long userId = (long) userMapper.insertUserInfo(userEntity);

        // 채팅방 - 사용자정보 매핑
        RoomUserMapDTO roomUserMapDTO = new RoomUserMapDTO(userVO.getRoomId(), userId);
        roomMapper.insertRoomUserMap(roomUserMapDTO);

        return userVO;
    }

    @Transactional
    public int updateUserProfile(UserVO userVO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userVO.getUserId());
        userEntity.setRoomId(userVO.getRoomId());
        userEntity.setUserName(userVO.getUserName());
        userEntity.setUserImg(userVO.getUserImg());

        return userMapper.updateUserProfile(userEntity);
    }
}
