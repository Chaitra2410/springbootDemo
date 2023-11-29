package net.training3.springbootrabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

	@Value("${rabbitmq.exchange.name}")
	private String exchnage;

	@Value("${rabbitmq.routing.key.name}")
	private String routingkey;

	private RabbitTemplate rabbitTemplate;

	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(String message) {
		LOGGER.info(String.format("Message Sent -> %s", message));
		rabbitTemplate.convertAndSend(exchnage, routingkey, message);
	}

}
