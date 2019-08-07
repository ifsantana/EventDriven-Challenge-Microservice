package com.eventdriven.challenge;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		final Ignite ignite = Ignition.start("apacheignite-cassandra.xml");
		ignite.cache("ClickEventCache").loadCache(null);
		ignite.cache("ViewEventCache").loadCache(null);

		SpringApplication.run(ChallengeApplication.class, args);
	}
}

