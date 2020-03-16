package com.wolfie.myWeb01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
public class MyWeb01Application {

	public static void main(String[] args) {
		SpringApplication.run(MyWeb01Application.class, args);
	}

}
