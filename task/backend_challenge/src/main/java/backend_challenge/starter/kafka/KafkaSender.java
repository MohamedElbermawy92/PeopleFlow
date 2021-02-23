package backend_challenge.starter.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;


@Service
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;
	
	
	@Bean
	public ProducerFactory<String, Message> greetingProducerFactory() {
		Map<String, Object> props = new HashMap<>();
		 props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	     props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

	     props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	    return new DefaultKafkaProducerFactory<>(props);
	    
	    
	}

	@Bean
	public KafkaTemplate<String, Message> greetingKafkaTemplate() {
	    return new KafkaTemplate<>(greetingProducerFactory());
	}
	
	
	String kafkaTopic = "Test1";
	
	public void send(String employeeName , String state) {
	    
		greetingKafkaTemplate().send(kafkaTopic, new Message(employeeName, state));
	}
}
