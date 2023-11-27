package com.example.springboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WkimediaChangesHandler implements EventHandler{

	 private static final Logger LOGGER = LoggerFactory.getLogger(WkimediaChangesHandler.class);

	    private KafkaTemplate<String, String> kafkaTemplate;
	    private String topic;


	
	public WkimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
			super();
			this.kafkaTemplate = kafkaTemplate;
			this.topic = topic;
		}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		 LOGGER.info(String.format("event data -> %s", messageEvent.getData()));

	        kafkaTemplate.send(topic, messageEvent.getData());
		
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
