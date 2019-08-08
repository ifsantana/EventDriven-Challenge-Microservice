package com.eventdriven.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);

//		final Ignite ignite = Ignition.start("apacheignite-cassandra.xml");
////		ignite.cache("ClickEventCache").loadCache(null);
//		ignite.cache("ViewEventCache").loadCache(null);
	}
}

