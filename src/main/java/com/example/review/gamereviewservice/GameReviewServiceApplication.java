package com.example.review.gamereviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EntityScan("com.example.review.gamereviewservice.model")
@EnableFeignClients(basePackages = "com.example.review.gamereviewservice.proxy")
@SpringBootApplication
public class GameReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameReviewServiceApplication.class, args);
	}

}
