//package br.app.Empresa.rabiit;
//
//import javax.naming.Binding;
//
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//
//public class Configure {
//
//	public static final String EXCHANGE_NAME = "nikeexchange";
//	public static final String QUEUE_NAME = "nikeque";
//   
//	
//	@Bean
//	public Queue createQueue() {
//
//		return new Queue(QUEUE_NAME,true);
//
//	}
//	
//	@Bean
//	TopicExchange exchange() {
//		return new TopicExchange(EXCHANGE_NAME);
//		
//	}
//	
//	@Bean
//	Binding biinding(Queue q , TopicExcahnge exchange){
//		
//		return BindingBuilder.bind(exchange(q).to(exchange).with("nike")           
//		
//	}
//
//}
