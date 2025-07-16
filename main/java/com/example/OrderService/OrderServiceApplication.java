package com.example.OrderService;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrderServiceApplication {

	public static void main(String[] args) {

		 Dotenv dotenv = Dotenv.configure().load();
		String port  = dotenv.get("PORT");
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(),port));
		System.out.println("PORT: "+port);
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
