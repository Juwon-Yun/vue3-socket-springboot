package com.example.vue.controller;

import com.example.vue.vo.SocketVO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {

    @MessageMapping("/receive")
    @SendTo("/send")
    public SocketVO socketHandler(SocketVO socketVO) {
        return new SocketVO(socketVO.getId()
                          , socketVO.getText()
                          , socketVO.getDate()
                          , socketVO.getAlarm()
                          , socketVO.getTextAreaText());
    }

    @MessageMapping("/alarm")
    @SendTo("/send")
    public SocketVO alarmHandler(SocketVO socketVO) {
        return new SocketVO(socketVO.getId()
                          , socketVO.getText()
                          , socketVO.getDate()
                          , socketVO.getAlarm()
                          , socketVO.getTextAreaText());
    }

}