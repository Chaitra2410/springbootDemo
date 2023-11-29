package net.training3.springbootrabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.training3.springbootrabbitmq.dto.User;
import net.training3.springbootrabbitmq.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

	private RabbitMQJsonProducer jsonProducer;

	public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
		this.jsonProducer = jsonProducer;
	}

	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
		jsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("Message sent to RabbitMQ!");
	}
}
