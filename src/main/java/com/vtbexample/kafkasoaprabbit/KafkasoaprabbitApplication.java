package com.vtbexample.kafkasoaprabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@PropertySource({
		"classpath:kafka.properties"
})
public class KafkasoaprabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkasoaprabbitApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}

}
