package com.spring.learn.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.learn.kafka.model.Customer;

@RestController
@RequestMapping("kafka")
public class KafkaResourceController {

	@Autowired
	KafkaTemplate<String, Customer> kafkaTemplate;
	
	private static final String TOPIC = "javalearn";
	
	@RequestMapping("/publish/{name}")
	private String postMessage(@PathVariable("name") final String name) {
		kafkaTemplate.send(TOPIC, new Customer(name, "IT", 200000L));
		return "Published Successfully";
		// TODO Auto-generated method stub

	}
}
