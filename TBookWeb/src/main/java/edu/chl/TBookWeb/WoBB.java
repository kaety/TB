/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.TBookWeb;

import edu.chl.tbook.core.IUserCatalogue;
import edu.chl.tbook.core.IWorkoutCatalogue;
import edu.chl.tbook.core.TBook;
import edu.chl.tbook.core.Workout;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author tapperk
 */
@Named("workout")
@ConversationScoped
public class WoBB implements Serializable{
   
   private IWorkoutCatalogue workCat = TBook.INSTANCE.getWorkoutCatalogue();
   private IUserCatalogue userCat = TBook.INSTANCE.getUserCatalogue();  
     
   FacesContext context = FacesContext.getCurrentInstance();
   HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
   
   public List<Workout> getAllworkouts(){
       List<Workout> wo;
       wo = workCat.getByOwner(userCat.find(request.getRemoteUser()));
       
       return wo;
  
   }
   

    public void action(Workout w) {
       
       workCat.remove(w.getId());
       
    }
    
}
