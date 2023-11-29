package com.example.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.WikimediaData;
import com.example.springboot.repository.WikimediaDataRepository;



@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

	private WikimediaDataRepository dataRepository;

	public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	// private KafkaTemplate<String, String> kafkaTemplate;
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String eventMessage) {
		LOGGER.info(String.format("Message received -> %s", eventMessage));

		WikimediaData wikimedia = new WikimediaData();
		wikimedia.setWikiEventData(eventMessage);

		dataRepository.save(wikimedia);
	}

}
