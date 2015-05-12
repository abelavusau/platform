package com.platform.web.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Reciever {
    @JmsListener(destination = "myMessageQueue")
    public void onMessage(Message message) {
	if (message instanceof ObjectMessage) {
	    ObjectMessage msg = (ObjectMessage) message;

	    try {
		System.out.println("OnMessage Received  :" + msg.getObject().toString());
	    } catch (JMSException e) {
		e.printStackTrace();
	    }
	}
    }
}
