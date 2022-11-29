package com.deepface.deepface.workflow;

import com.deepface.deepface.business.ImageManager;
import com.deepface.deepface.database.Image;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface DeepFaceWorkflows {

    @WorkflowMethod
    Void processImage(Image image);

}
