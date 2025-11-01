package com.moyeo.service;

import com.moyeo.VO.UserVO;
import com.moyeo.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserVO> userList(Long id);
    UserVO addUserInfo(UserVO userVO);
    UserVO getUserInfo(UserVO userVO);
    int updateUserProfile(UserVO userVO);
}
