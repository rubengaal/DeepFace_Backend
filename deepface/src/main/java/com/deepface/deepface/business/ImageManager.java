package com.deepface.deepface.business;

import com.deepface.deepface.database.Image;
import com.deepface.deepface.repository.ImageRepository;
import io.temporal.api.common.v1.ActivityTypeOrBuilder;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageManager {

    @Autowired
    ImageRepository imageRepo;

    public ImageManager() {
    }

    public Boolean InsertImage(Image image){

        try{
            imageRepo.save(image);
        }
        catch(Exception e){
            return false;
        }

        return true;
    }

    public Image findImageById(String id){

        try{
            return imageRepo.findImageById(id);
        }
        catch(Exception e){
            throw new IllegalArgumentException("The given id is not valid. Id: " + id);
        }
    }

    public Flux<ServerSentEvent<Image>> getImage(String id) {

         if (id != null && !id.isBlank() ){

             return Flux.interval(Duration.ofSeconds(20))
                     .map(sequence -> ServerSentEvent.<Image>builder().id(String.valueOf(sequence))
                             .event("image-update-event").data(imageRepo.findImageById(id))
                             .build());

         }
        return Flux.interval(Duration.ofSeconds(20))
                .map(sequence -> ServerSentEvent.<Image>builder().id(String.valueOf(sequence))
                        .event("image-update-event").data(null)
                        .build());
    }

    public Image findImageByName(String name){
        try{
            return imageRepo.findImageById(name);
        }
        catch(Exception e){
            throw new IllegalArgumentException("The given name doesn't exist. Name: " + name);
        }
    }

}
