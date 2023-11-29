package net.training3.springbootrabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.training3.springbootrabbitmq.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

	private RabbitMQProducer rabbitMQProducer;

	public MessageController(RabbitMQProducer rabbitMQProducer) {
		this.rabbitMQProducer = rabbitMQProducer;
	}

	// http://localhost:8080?api/v1/publish?messahe=hello
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
		rabbitMQProducer.sendMessage(message);
		return ResponseEntity.ok("Message Sent to RabbitMQ!");
	}

}
