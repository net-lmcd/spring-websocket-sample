package com.kt.websocket.demo.stomp.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Message {
    private String from;
    private String text;
}
