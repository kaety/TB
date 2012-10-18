/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.TBookWeb;

import edu.chl.tbook.core.Exercise;
import edu.chl.tbook.core.IExerciseCatalogue;
import edu.chl.tbook.core.TBook;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Kristofer
 */
@Named("exercises")
@SessionScoped
public class ExBB implements Serializable{
    private IExerciseCatalogue ExCat = TBook.INSTANCE.getExerciseCatalogue();
    private Exercise selected;
    
    public List<Exercise> getExes(){
        return ExCat.getAll();
    }
    
     public Exercise getSelected() {  
        return selected;  
    }  
  
    public void setSelected(Exercise selected) {  
        this.selected = selected;  
    }  
}
