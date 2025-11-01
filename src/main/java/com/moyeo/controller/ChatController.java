package com.moyeo.controller;

import com.moyeo.dto.ChatMessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;

    /**
     * 사용자가 채팅 메시지를 보낼 때
     * 클라이언트는 /app/chat/{roomId}/send 로 메시지를 보냄
     */
    @MessageMapping("/{roomId}/send")
    public void sendMessage(@DestinationVariable String roomId,
                            @Payload ChatMessageDTO message) {

        if (message.getType() == ChatMessageDTO.MessageType.ENTER) {
            message.setMessage(message.getSender() + "님이 입장했습니다.");
        } else if (message.getType() == ChatMessageDTO.MessageType.NOTICE) {
            // 공지 메시지 처리
        } else if (message.getType() == ChatMessageDTO.MessageType.TALK) {
            // 일반 메시지 처리
        }

        // 방에 있는 모든 구독자에게 메시지 전송
        messagingTemplate.convertAndSend("/sub/room/" + roomId, message);
    }

    /**
     * 사용자가 방에 입장했을 때
     * 클라이언트는 /app/chat/{roomId}/enter 로 보냄
     */
    @MessageMapping("/chat/{roomId}/enter")
    public void enterRoom(@DestinationVariable String roomId,
                          @Payload ChatMessageDTO message) {

        if (message.getType() == ChatMessageDTO.MessageType.ENTER) {
            message.setMessage(message.getSender() + "님이 입장했습니다.");
        } else if (message.getType() == ChatMessageDTO.MessageType.NOTICE) {
            // 공지 메시지 처리
        } else if (message.getType() == ChatMessageDTO.MessageType.TALK) {
            // 일반 메시지 처리
        }

        messagingTemplate.convertAndSend("/sub/room/" + roomId, message);
    }
}
