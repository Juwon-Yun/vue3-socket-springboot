package com.example.vue.Service;

import com.example.vue.vo.MessageDTO;
import com.example.vue.vo.MsgRoomDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MsgService {

	private final ObjectMapper objectMapper;
	private Map<String, MessageDTO> msgRooms;

	@PostConstruct
	private void init(){
		msgRooms = new LinkedHashMap<>();
	}

	public List<MsgRoomDTO> findAllRoom(){
		return new ArrayList<>(msgRooms.values());
	}

	public MsgRoomDTO findById(String roomId){
		return msgRooms.get(roomId);
	}

	public MsgRoomDTO createRoom(String name){
		String roomId = name;
		return MsgRoomDTO.builder().roomId(roomId).build();
	}

	public <T> void sendMessage(WebSocketSession session, T Message){

	}
}
