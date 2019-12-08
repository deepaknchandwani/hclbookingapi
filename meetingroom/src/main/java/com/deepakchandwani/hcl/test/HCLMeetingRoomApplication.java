package com.deepakchandwani.hcl.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The Class HCLMeetingRoomApplication.
 */
@SpringBootApplication
@ComponentScan("com.deepakchandwani")
@EnableJpaRepositories("com.deepakchandwani.hcl.test.repository")
@EntityScan("com.deepakchandwani.hcl.test.entity")
public class HCLMeetingRoomApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(HCLMeetingRoomApplication.class, args);
	}
}
