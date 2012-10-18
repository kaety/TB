/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.TBookWeb;

import edu.chl.tbook.core.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named("profile")
@RequestScoped
public class ProfileBB implements Serializable{
   
   
   private IUserCatalogue userCat = TBook.INSTANCE.getUserCatalogue(); 
   
   FacesContext context = FacesContext.getCurrentInstance();
   HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
   
    public String getFname(){
        
        return userCat.find(request.getRemoteUser()).getfName();
        
    }
    
    public String getLname(){
        
        return userCat.find(request.getRemoteUser()).getlName();
        
    }
    
    public String getEmail(){
        
        return userCat.find(request.getRemoteUser()).geteMail();
        
    }
    
    public String getWon(){
        IWorkoutCatalogue workCat = TBook.INSTANCE.getWorkoutCatalogue();
         Workout wo = workCat.ownersNextWorkout(userCat.find(request.getRemoteUser()));
         if(wo== null){
             return "NO NEXT WORKOUT";
         }
         else{
         return wo.getName();
         }
    }
   

}
