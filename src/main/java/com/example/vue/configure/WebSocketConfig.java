package com.example.vue.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	// EnableWebSocketMessageBroker 이름에서 알 수 있듯이
	// MessageBroker가 지원하는 WebSocket Message 처리를 활성화한다.
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry registry){
		// MessageBroker를 구성하기 위한 기본 방법을 구현한다.
		// enableSimpleBroker() 단순 메모리 기반의 MessageBroker가 붙은 대상의 클라이언트에
		// 메세지를 다시 전달 할 수 있도록 호출하는 것으로 시작 한다 (/topic)또한
		// (/app) @MessageMapping주석이 달린 메서드에 바인딩된 메시지의 접두사를 지정한다.

		// /app/hello는 GreetingController.greeting() 메소드가 처리하도록 매핑되는 것이다.
//		registry.enableSimpleBroker("/alarm");

//	}
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		registry.enableSimpleBroker("/alarm");
//	}
//
//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		registry.addEndpoint("/").setAllowedOriginPatterns("*").withSockJS();
//	}
//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry registry){
//		// registerStompEndpoints() 메소드는 /gs-guid-websocket 끝점을 등록하여
//		// WebSocket을 사용할 수 없는 경우 대체 전송을 사용할 수 있도록 Sockjs 풀백 옵션을 활성화한다.
//		// SockJS 클라이언트는 사용 가능한 최상의 전송(websocket, xhr-streaming, xhr-polling 등)에 연결하여 사용하려고 시도한다.
//		registry.addEndpoint("/gs-guide-websocket").withSockJS();
//	}

}
