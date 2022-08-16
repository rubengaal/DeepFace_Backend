package com.deepface.deepface.business;

import com.deepface.deepface.database.Image;
import com.deepface.deepface.repository.ImageRepository;
import io.temporal.api.common.v1.ActivityTypeOrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageManager {

    ImageRepository imageRepo;

    public Boolean InsertImage(String name, String dataUrl){

        try{
            imageRepo.save(new Image(dataUrl, name));
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

    public Image findImageByName(String name){
        try{
            return imageRepo.findImageById(name);
        }
        catch(Exception e){
            throw new IllegalArgumentException("The given name doesn't exist. Name: " + name);
        }
    }

    public Image UpdateImage(String id, Image image){
        Image updatedImage = imageRepo.updateImage(id, image);
        if (updatedImage != null){
            return updatedImage;
        }else{
            throw new IllegalArgumentException("The given id is not valid. Id: " + id);
        }
    }

    public List<Image> getAllImages(){
        return imageRepo.getAllImages();
    }
}
