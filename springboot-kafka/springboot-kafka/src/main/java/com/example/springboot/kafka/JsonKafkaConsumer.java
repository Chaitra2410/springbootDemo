package com.example.springboot.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.springboot.payload.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class JsonKafkaConsumer {
	@Value("${spring.kafka.topic-json.name}")
	private String topicJsonName;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user){
        LOGGER.info(String.format("Message received -> %s", user));
    }

}
