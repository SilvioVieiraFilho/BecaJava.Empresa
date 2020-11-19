package com.eleicao.rabbit;



import org.springframework.web.client.RestTemplate;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


public class Principal {

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		
		
	
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			
			
			String message = new String(delivery.getBody(), "UTF-8");//
	        
			
			
			String hashContaHotel = "c7959779-d787-40ac-945c-1b0c4ad2b666";

			RestTemplate restTemplate = new RestTemplate();
			
			
			
			String uri = "http://localhost:8081/operacao/transferencia";
			
			
			 restTemplate.postForObject(uri, message);
			
			
			//resttemplate e vai manda api pro banco operacao/transferencia
	
			
			
		};
		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
		});
	}
}