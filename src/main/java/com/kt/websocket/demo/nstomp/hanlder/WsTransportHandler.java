package com.kt.websocket.demo.nstomp.hanlder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/*  WebSocketHandler를 상속받은 클래스는 직접 세션레벨에서 데이터를 Handle 해야한다 */
@Slf4j
@Component
public class WsTransportHandler extends TextWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("session connected = " + session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("session closed = " + session);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("transport Error = " + session + ", exception = " + exception);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info("handle Message = " + session + ", message = " + message);
        session.sendMessage(message);
    }
}
