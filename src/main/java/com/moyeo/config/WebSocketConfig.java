package com.moyeo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {  // 구독, 전송시 접두사 설정
        config.enableSimpleBroker("/sub");  // 메세지 받을 때
        config.setApplicationDestinationPrefixes("/pub");   // 메세지 보낼 때
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {  // Socket 연결시 Endpoint
        registry.addEndpoint("/ws")
                .setAllowedOrigins("*")  // CORS 설정
                .withSockJS();  // 브라우저별 WebSocket을 지원하지 않을 경우, withSockJS가 대체 옵션 지원
    }
}
