package com.javainuse.websocket.config;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;

import org.json.JSONObject;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
@Controller
@Component
public class SocketTextHandler extends TextWebSocketHandler {
int l=0;
float max = 600;
float min =100;
String[] list,ouput;
int id=0;
HashMap<Integer, String> hash_map = new HashMap<Integer, String>(); 
ArrayList<Integer> google = new ArrayList<Integer>(100);
ArrayList<Integer> hotmail = new ArrayList<Integer>(100);
BrokerMessage  borkerMessage =  new  BrokerMessage();
WebSocketSession session;
@EventListener(SessionConnectEvent.class)
public void handleWebsocketConnectListner(SessionConnectEvent event) throws IOException {
	
	
	
}
@Override
public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    // The WebSocket has been opened
    // I might save this session object so that I can send messages to it outside of this method

    // Let's send the first message
  

	

	session.sendMessage(new TextMessage("jjjjj"));
	String[] names = {"google","hotmail","netflix","yahoo"};
	int i =0,j=0;
	while(i==0) {
		Thread.sleep(1000);
		
		if(j<names.length)
		{
			session.sendMessage(new TextMessage("Y"+names[j]));
			new TextGeneratorRandom().TextGenerator(names[j],session, max, min, i);
		
		}
		
		else {
			j=0;
		}
		j++;
	}

	
}

	@Override
	@SendToUser 
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		
		session.sendMessage(new TextMessage("hello"));
		
		String payload = message.getPayload();
		JSONObject jsonObject = new JSONObject(payload);
		if(jsonObject.getString("user").equals("google")) {
			google.add(Integer.parseInt(session.getId()));
			new TextGeneratorRandom().show(session.getId()+"",session);
			while(true) {
				 new TextGeneratorRandom().show("hello",session);
				
			}
		}
		if(jsonObject.getString("user").equals("hotmail")) {
			hotmail.add(Integer.parseInt(session.getId()));
			new TextGeneratorRandom().show(session.getId()+"",session);
		}
		
		int i=0,l=0;
		
				
				
				
	}
	
		
				
				
				
				
			
			
		
	

		
	
		 

	@EventListener(SessionDisconnectEvent.class)
	public void handleWebsocketDisconnectListner(SessionDisconnectEvent event) {
		  System.out.print("hello");
	}
	
	}


	

