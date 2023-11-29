package net.training3.springbootrabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${rabbitmq.queue.name}")
	private String queue;

	@Value("${rabbitmq.queue.json.name}")
	private String jsonQueue;

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key.name}")
	private String routingkey;

	@Value("${rabbitmq.routing.json.key.name}")
	private String jsonRoutingkey;

	// spring bean for rabbit MQ queue
	@Bean
	public Queue queue() {
		return new Queue(queue);
	}

	// Spring bean for queue(json)
	@Bean
	public Queue jsonQueue() {
		return new Queue(jsonQueue);
	}

	// spring bean for rabbitmq exchange
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	// Binding between queue and exchange using routing
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(routingkey);
	}

	// Binding between queue & exchange using routing key
	@Bean
	public Binding jsonBinding() {
		return BindingBuilder.bind(jsonQueue()).to(exchange()).with(jsonRoutingkey);
	}

	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemp = new RabbitTemplate(connectionFactory);
		rabbitTemp.setMessageConverter(converter());
		return rabbitTemp;

	}

	// ConnectionFactory

	// RabbitTemplate

	// RabbitAdmin

}
