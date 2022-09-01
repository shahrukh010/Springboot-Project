package com.code.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.code.main.model.Product;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "testTopic";

	@GetMapping("/publishJson")
	public String publishMessage() {

		List<Product> products = List.of(new Product(1111, "Dell-Laptop", 140500, 3),
				new Product(2222, "Lenevo-laptop", 50000, 4), new Product(3333, "Hp-laptop", 2.50000, 4),
				new Product(4444, "Acer-laptop", 75000, 2), new Product(5555, "Processor", 50000, 4),
				new Product(6666, "Keyboard", 25000, 10), new Product(7777, "Mouse", 30000, 4),
				new Product(6666, "Camera", 45000, 2), new Product(7777, "Ram", 30000, 14));

		for (Product product : products) {

			template.send(topic, product);
		}

		return "Json Data publish";
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}

}
