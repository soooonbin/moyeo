package com.moyeo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    private Long userId;
    private Long roomId;
    private String userName;
    private int userImg;
    private String userColor;
}
