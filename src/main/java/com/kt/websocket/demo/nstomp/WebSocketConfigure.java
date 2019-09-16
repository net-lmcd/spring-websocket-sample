package com.kt.websocket.demo.nstomp;

import com.kt.websocket.demo.nstomp.hanlder.WsTransportHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Profile("nstomp")
@Configuration
@EnableWebSocket
public class WebSocketConfigure implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        // WebSocket 을 사용할 수없는 경우 대체 전송을 사용할 수 있도록 SockJS 폴백 옵션을 활성화
        webSocketHandlerRegistry.addHandler(new WsTransportHandler(), "/ws").setAllowedOrigins("*").withSockJS();
    }

}
