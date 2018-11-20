package com.javainuse.websocket.config;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import org.slf4j.Logger;
public class BrokerMessage {
String id;
String Subricber_channel;

public int i=0;
//private static final  Logger logger=LoggerFactory.getLogger(BrokerMessage.class);
public String getSubricber_channel() {
	return Subricber_channel;
}

public void setSubricber_channel(String subricber_channel) {
	Subricber_channel = subricber_channel;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}
public String  UserAndSubcriber(String id,String Subcribrer) {
	
	//logger.debug("working");
	
	return id+','+Subcribrer;

}


}
