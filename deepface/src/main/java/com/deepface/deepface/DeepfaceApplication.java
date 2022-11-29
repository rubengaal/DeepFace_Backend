package com.deepface.deepface;


import com.deepface.deepface.workflow.DeepFaceWorkflowsImpl;
import com.deepface.deepface.workflow.FaceGenerationImpl;
import com.deepface.deepface.workflow.Shared;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class DeepfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeepfaceApplication.class, args);
		WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
		WorkflowClient client = WorkflowClient.newInstance(service);
		// Create a Worker factory that can be used to create Workers that poll specific Task Queues.
		WorkerFactory factory = WorkerFactory.newInstance(client);
		Worker worker = factory.newWorker(Shared.GEN_TASK_QUEUE);
		// This Worker hosts both Workflow and Activity implementations.
		// Workflows are stateful, so you need to supply a type to create instances.
		worker.registerWorkflowImplementationTypes(DeepFaceWorkflowsImpl.class);
		// Activities are stateless and thread safe, so a shared instance is used.
		worker.registerActivitiesImplementations(new FaceGenerationImpl());
		// Start polling the Task Queue.
		factory.start();
	}

}



