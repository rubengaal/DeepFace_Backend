package com.deepface.deepface.workflow;

import com.deepface.deepface.business.ImageManager;
import com.deepface.deepface.controllers.MainController;
import com.deepface.deepface.database.Image;
import lombok.SneakyThrows;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class FaceGenerationImpl implements FaceGeneration {

    Logger logger = LoggerFactory.getLogger(FaceGenerationImpl.class);

    @Override
    @SneakyThrows
    public void startGenerating(String Id) {
        SseEmitter emitter = new SseEmitter();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() ->{
            logger.info("Generating 3D model from image... with id: "+ Id);

            try{
                HttpGet request = new HttpGet("http://127.0.0.1:8000/generate/" + Id);
                CloseableHttpClient client = HttpClients.createDefault();
                CloseableHttpResponse response = client.execute(request);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                logger.info(result);

                //SseEmitter.SseEventBuilder eventBuilder = SseEmitter.event();

               /* emitter.send( eventBuilder
                        .data(result)
                        .name("face-generated-event")
                        .id(String.valueOf(result.hashCode())));

                emitter.complete();*/
            }
            catch(Exception e){
                logger.info(e.toString());
                //emitter.completeWithError(e);
            }
        });
        executor.shutdown();
    }

    @Override
    public void startAnalyzing(String Id) {
        logger.info("Analyzing face...with id: "+ Id);
    }
}
