package com.kt.websocket.demo.data;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @RequiredArgsConstructor
public class OutputMessage {
    @NonNull private String from;
    @NonNull private String message;
    @NonNull private String topic;
    private Date time = new Date();
}
