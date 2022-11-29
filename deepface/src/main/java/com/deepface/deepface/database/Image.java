package com.deepface.deepface.database;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

@Document("Images")
public class Image {

    public Image() {
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMtlUrl() {
        return mtlUrl;
    }

    public void setMtlUrl(String mtlUrl) {
        this.mtlUrl = mtlUrl;
    }

    public String getObjUrl() {
        return objUrl;
    }

    public void setObjUrl(String objUrl) {
        this.objUrl = objUrl;
    }

    public String getPngUrl() {
        return pngUrl;
    }

    public void setPngUrl(String pngUrl) {
        this.pngUrl = pngUrl;
    }

    public String getDetailObjUrl() {
        return detailObjUrl;
    }

    public void setDetailObjUrl(String detailObjUrl) {
        this.detailObjUrl = detailObjUrl;
    }

    public String getNormalsUrl() {
        return normalsUrl;
    }

    public void setNormalsUrl(String normalsUrl) {
        this.normalsUrl = normalsUrl;
    }
}
