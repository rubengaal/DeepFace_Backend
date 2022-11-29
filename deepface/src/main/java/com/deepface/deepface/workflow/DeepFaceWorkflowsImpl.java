package com.deepface.deepface.workflow;

import com.deepface.deepface.business.ImageManager;
import com.deepface.deepface.controllers.MainController;
import com.deepface.deepface.database.Image;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import io.temporal.workflow.WorkflowMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

public class DeepFaceWorkflowsImpl implements DeepFaceWorkflows{

    ActivityOptions options = ActivityOptions.newBuilder().setScheduleToCloseTimeout(Duration.ofSeconds(400)).build();
    private final FaceGeneration faceGeneration = Workflow.newActivityStub(FaceGeneration.class, options);
    Logger logger = LoggerFactory.getLogger(DeepFaceWorkflowsImpl.class);

    @Override
    public Void processImage(Image image) {
        faceGeneration.startAnalyzing(image.getId());
        faceGeneration.startGenerating(image.getId());
        return null;
    }

}
