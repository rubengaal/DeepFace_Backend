package com.deepface.deepface.repository;
import com.deepface.deepface.database.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;;
import java.util.List;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {

    @Query("{name:'?0'}")
    Image findImageByName(String name);

    @Query("{'_id' : ?0}")
    Image findImageById(String id);

    public long count();
}
