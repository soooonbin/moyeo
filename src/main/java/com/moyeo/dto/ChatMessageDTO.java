package com.moyeo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDTO {
    public enum MessageType {
        ENTER, TALK, NOTICE
    }

    private String roomId;
    private String sender;   // 사용자 닉네임
    private String message;  // 메시지 내용
    private MessageType type;
}
