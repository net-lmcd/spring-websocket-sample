package com.kt.websocket.demo.stomp.api;


import com.kt.websocket.demo.stomp.data.Message;
import com.kt.websocket.demo.stomp.data.OutputMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class GreetingController {

    /**
     * if a message is sent to destination "/hello", then the greeting() method is called
     * The payload of the message is bound to a HelloMessage object which is passed into greeting()
     * after 1 second of delay, the greeting() method creates a Greeting object and returns it.
     * The return value is broadcast to all subscribers to  "/topic/messages"
     * */
    @MessageMapping("/chat/{topic}")
    @SendTo("/topic/messages")
    public OutputMessage send(@DestinationVariable("topic") String topic, Message message) throws Exception {
        log.info("/topic/messages");
        return new OutputMessage(message.getFrom(), message.getText(), topic);
    }
}
