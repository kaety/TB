/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.TBookWeb;

import edu.chl.tbook.core.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("addexercise")
@SessionScoped
public class AdminAddExBB implements Serializable {

    private IExerciseCatalogue exerciseCat = TBook.INSTANCE.getExerciseCatalogue();
    private String ename = "";
    private String picture = "";
    private String description = "";

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
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

    public String action() {
        Exercise e = new Exercise(ename, picture, description);
        exerciseCat.add(e);
        ename="";
        picture="";
        description="";
        Logger.getAnonymousLogger().log(Level.INFO, "added exercise {0}", e);
        return "adminindex?faces-redirect=true";  // Where to go, navigate 
    }

    public String cancel() {
        return "adminindex?faces-redirect=true";
    }
}
