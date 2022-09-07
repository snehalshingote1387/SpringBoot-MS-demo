package com.political.leader.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * This class define PoliticalLeaderSpringBootApplication
 * 
 * @author eyjasgt08
 *@since 2022
 */

@SpringBootApplication
@EnableEurekaClient
public class PoliticalLeaderSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliticalLeaderSpringBootApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	return new RestTemplate();
	}

}
