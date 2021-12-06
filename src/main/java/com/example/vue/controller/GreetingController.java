//package com.example.vue.controller;
//
//import com.example.vue.vo.Greeting;
//import com.example.vue.vo.HelloMessage;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.util.HtmlUtils;
//
//@Controller
//public class GreetingController {
//
//	@MessageMapping("/hello")
//	@SendTo("/topic/greetings")
//	public Greeting greeting(HelloMessage message) throws Exception{
//		// 내부족으로 메소드 구현을 1초 동안 절전 모드로 전환되도록 하여 처리 지연을 시뮬레이션함
//		// 이유로는 클라이언트가 메시지를 보낸 후 서버가 메시지를 비동기식으로 처리해야 하는 만큼 시간이 걸릴 수 있으므로
//		// 시각적으로 보여주기 위함임, 클라이언트는 응답을 기다리지 않고 필요한 작업을 계속할 수 있다.
//		Thread.sleep(1000); // simulated delay
//		// 1초 지연 후에 greeting메소드는 Greeting 개체를 만들고 반환한다.
//		// 반환값은 /topic/greetings에 지정된 모든 사용자에게 보내진다 ( @SendTo )
//		// 이때 입력 메세지의 이름은 삭제된다 => 클라이언트 측의 브라우저 DOM에서 다시 echo되고 다시 redering 되기 때문
//		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + " !!!");
//	}
//
//}
