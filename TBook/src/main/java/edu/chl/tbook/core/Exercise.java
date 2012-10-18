package edu.chl.tbook.core;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Exercise implements Serializable{
    
    @Id
    private String ename;
    private String picture;
    private String description;

    public Exercise() {
    }

    public Exercise(String ename, String picture, String description) {
        this.ename = ename;
        this.picture = picture;
        this.description = description;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String eName) {
        this.ename = eName;
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
