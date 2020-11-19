package br.app.Empresa.Config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

	public  final String QUEUE = "FilaTestee";
	public static final String EXCHANGE = "PlayJavaExchange";
	public static final String ROUTING_KEY = "PlayJavaRoutingKey";

	@Bean
	Queue queue() {

		return new Queue(QUEUE, false);

	}

	@Bean
	DirectExchange exchange() {

		return new DirectExchange(EXCHANGE);

	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {

		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);

	}

	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}

}
