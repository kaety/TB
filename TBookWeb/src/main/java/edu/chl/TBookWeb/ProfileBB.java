/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.TBookWeb;

import edu.chl.tbook.core.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named("profile")
@SessionScoped
public class ProfileBB implements Serializable{
    
   private IUserCatalogue userCat = TBook.INSTANCE.getUserCatalogue(); 
   private IWorkoutCatalogue workCat = TBook.INSTANCE.getWorkoutCatalogue(); 
   
   FacesContext context = FacesContext.getCurrentInstance();
   HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
   
   private TBookUser tbuser = userCat.find(request.getRemoteUser());
   private Workout nextworkout = workCat.ownersNextWorkout(tbuser);
   
   private String fName=tbuser.getfName();
   private String lName=tbuser.getlName();
   private String email=tbuser.geteMail();
   private List<Exercise> ex= nextworkout.getEx();
   private String namenextWorkout=nextworkout.getName();
   //MAKE TO DATE
   private Long workoutTime= nextworkout.getWorkoutTime();

    public List<Exercise> getEx() {
        return ex;
    }

    public void setEx(List<Exercise> ex) {
        this.ex = ex;
    }

    public String getName() {
        return namenextWorkout;
    }

    public void setName(String name) {
        this.namenextWorkout = name;
    }

    public Long getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(Long workoutTime) {
        this.workoutTime = workoutTime;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
    
}
