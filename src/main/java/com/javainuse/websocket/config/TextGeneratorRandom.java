package com.javainuse.websocket.config;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import java.util.Random;

import java.io.IOException;
import java.util.Random;

import org.json.JSONObject;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class TextGeneratorRandom {
	public double TextGenerator(String name,WebSocketSession session, float max,float min,int i) throws IOException {
		i=i+1;
		Random rand = new Random();
		double r =Math.round(((Math.random() * ((max - min) + 1)) + min)*100)/100;
		String str = name+":" +r +""+session.getId();
		show(str,session);
		return r;
			
		
	}
	public double TextGeneratorSubcription(String name,WebSocketSession session, float max,float min,int i) throws IOException {
		i=i+1;
		Random rand = new Random();
		double r =Math.round(((Math.random() * ((max - min) + 1)) + min)*100)/100;
		String str = name+"=" +r +""+session.getId();
		show(str,session);
		return r;
			
		
	}
	public void show(String msg,WebSocketSession session) throws IOException {
		session.sendMessage(new TextMessage(msg));
		
	}
}
