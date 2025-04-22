package com.davidcamelo.eureka.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		log.info("Current java.home {}", System.getProperty("java.home"));
		log.info("Current java.vendor {}", System.getProperty("java.vendor"));
		log.info("Current java.vendor.url {}", System.getProperty("java.vendor.url"));
		log.info("Current java.version {}", System.getProperty("java.version"));

		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
