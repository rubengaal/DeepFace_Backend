package com.deepface.deepface.workflow;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface FaceGeneration {

    @ActivityMethod
    void uploadToDatabase(String dataUrl);

    @ActivityMethod
    void startGenerating(String dataUrl);

    @ActivityMethod
    void startAnalyzing(String dataUrl);
}
