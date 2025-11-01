package com.moyeo.mapper;

import com.moyeo.VO.UserVO;
import com.moyeo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserVO> getUserList(Long roomId);
    UserVO getUserInfo(UserEntity userEntity);
    UserVO getUserById(Long id);
    int insertUserInfo(UserEntity userEntity);
    int updateUserProfile(UserEntity userEntity);
}
