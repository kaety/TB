package edu.chl.tbook;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Exercise implements Serializable{
    
    @Id
    private String eName;
    private String picture;
    private String description;

    public Exercise() {
    }

    public Exercise(String eName, String picture, String description) {
        this.eName = eName;
        this.picture = picture;
        this.description = description;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
}
