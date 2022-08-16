package com.deepface.deepface.database;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

@Document("Images")
public class Image {

    @Id
    private String id;
    private String dataUrl;
    private String name;
    private String mtlUrl;
    private String objUrl;
    private String pngUrl;
    private String detailObjUrl;
    private String normalsUrl;

    public Image(String dataUrl,
                 String name,
                 String mtlUrl,
                 String objUrl,
                 String pngUrl,
                 String detailObjUrl,
                 String normalsUrl) {
        super();
        this.dataUrl = dataUrl;
        this.name = name;
        this.mtlUrl = mtlUrl;
        this.objUrl = objUrl;
        this.pngUrl = pngUrl;
        this.detailObjUrl = detailObjUrl;
        this.normalsUrl = normalsUrl;
    }

    public Image(String dataUrl, String name) {
        this.dataUrl = dataUrl;
        this.name = name;
    }
}
