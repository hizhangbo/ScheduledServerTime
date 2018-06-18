package top.crazybanana.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import top.crazybanana.model.Message;

@Controller
public class ChatController {

    @MessageMapping("/chatting")
    @SendTo("/msg")
    public Message chatting(Message message){
        return message;
    }
}
