package com.deepface.deepface.repository;
import com.deepface.deepface.database.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;;
import java.util.List;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {

    @Query("{name:'?0'}")
    Image findImageByName(String name);

    @Query("{id:'?0'}")
    Image findImageById(String id);

    @Query
    List<Image> getAllImages();

    @Update("{id: '?0'}")
    Image updateImage(String id, Image image);

    public long count();
}
