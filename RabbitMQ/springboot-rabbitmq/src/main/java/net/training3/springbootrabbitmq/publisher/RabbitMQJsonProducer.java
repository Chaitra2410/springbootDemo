package net.training3.springbootrabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.training3.springbootrabbitmq.dto.User;

@Service
public class RabbitMQJsonProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

	@Value("${rabbitmq.exchange.name}")
	private String exchnage;

	@Value("${rabbitmq.routing.json.key.name}")
	private String jsonRoutingkey;

	private RabbitTemplate rabbitTemplate;

	public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendJsonMessage(User user) {
		LOGGER.info(String.format("Json message sent -> %s", user.toString()));
		rabbitTemplate.convertAndSend(exchnage, jsonRoutingkey, user);
	}
}
