package com.deepface.deepface.controllers;

import com.deepface.deepface.business.ImageManager;
import com.deepface.deepface.database.Image;
import com.deepface.deepface.workflow.DeepFaceWorkflows;
import com.deepface.deepface.workflow.Shared;
import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/main")
@CrossOrigin
public class MainController {

    @Autowired
    ImageManager imageManager;
    Logger logger = LoggerFactory.getLogger(MainController.class);

    String currentId = "7fa7c36e-1397-4370-80fc-8e0b1ed3c83f";


    @Autowired
    Gson gson;
    //@PostMapping(path = "/generate")
    @ResponseBody
    @RequestMapping(
            value = "/generate",
            method = RequestMethod.POST,
            consumes = MediaType.TEXT_PLAIN_VALUE)
    public void generateModel(@RequestBody String dataurl) {
        Image image = new Image();
        image.setDataUrl(dataurl);
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(Shared.GEN_TASK_QUEUE)
                .build();

        UUID uuid = UUID.randomUUID();
        image.setId(uuid.toString());
        currentId = uuid.toString();
        this.saveImage(image);

        //workflow trigger

        DeepFaceWorkflows workflows = client.newWorkflowStub(DeepFaceWorkflows.class,options);
        workflows.processImage(image);
    }

    @GetMapping("/image")
    public String getImage() {
        String connectionString = "mongodb+srv://deepcheap:pirosbicikli666@deepface.srk0atu.mongodb.net/test";
        Document img = new Document();
        if (currentId != null) {
            try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                MongoDatabase sampleTrainingDB = mongoClient.getDatabase("DeepFace");
                MongoCollection<Document> gradesCollection = sampleTrainingDB.getCollection("Images");
                img = gradesCollection.find(eq("_id", currentId)).first();
            }
        }
        logger.info("response: " + img.toJson());
        return img.toJson();
    }

    private void saveImage(Image image) {
        logger.info("Saving image to database...");
        Boolean success = imageManager.InsertImage(image);
        if (success){
            logger.info("Saved image with id: "+image.getId()+" to the database..." );
        } else {
            logger.info("Failed to save image with id: "+image.getId()+" to the database...");
        }
        logger.info("Initiating model reconstruction...");
    }
}
