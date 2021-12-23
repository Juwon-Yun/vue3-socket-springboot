package com.example.vue.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
	public enum MessageType{
		ENTER, COMM
	}

	private MessageType messageType;
	private String roomId;
	private String sender;
	private String message;

}
