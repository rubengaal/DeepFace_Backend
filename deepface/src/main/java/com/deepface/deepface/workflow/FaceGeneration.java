package com.deepface.deepface.workflow;

import com.deepface.deepface.business.ImageManager;
import com.deepface.deepface.database.Image;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@ActivityInterface
public interface FaceGeneration {

    @ActivityMethod
    void startGenerating(String Id);

    @ActivityMethod
    void startAnalyzing(String Id);
}
