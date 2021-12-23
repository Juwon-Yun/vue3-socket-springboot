package com.example.vue.controller;

import com.example.vue.Service.MsgService;
import com.example.vue.vo.MsgRoomDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class MsgController {

	private final MsgService msgService;

//	@MessageMapping("/comm/message)
//	public void message(Message message){
//		if(message.M)
//	}

	public MsgRoomDTO createRoom(@RequestParam String name){
		return msgService.createRoom(name);
	}

	@GetMapping
	public List<MsgRoomDTO> findAllRoom(){
		return msgService.findAllRoom();
	}

}
