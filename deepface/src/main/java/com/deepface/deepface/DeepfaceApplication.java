package com.deepface.deepface;

import com.deepface.deepface.repository.ImageRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories()
@ComponentScan("com.deepface.deepface")
public class DeepfaceApplication {



	public static void main(String[] args) {
		SpringApplication.run(DeepfaceApplication.class, args);
	}

	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create("mongodb+srv://deepcheap:pirosbicikli666@deepface.srk0atu.mongodb.net/?retryWrites=true&w=majority");
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoClient mongoClient) throws Exception {
		return new MongoTemplate(mongoClient, "databaseName");
	}
}


