/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.TBookWeb;

import edu.chl.tbook.core.Exercise;
import edu.chl.tbook.core.IExerciseCatalogue;
import edu.chl.tbook.core.IWorkoutCatalogue;
import edu.chl.tbook.core.TBook;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("removeexercise")
@SessionScoped
public class AdminRemoveExBB implements Serializable {

    private IExerciseCatalogue exerciseCat = TBook.INSTANCE.getExerciseCatalogue();

    public List<Exercise> getExercises() {
        return exerciseCat.getAll();
    }

    public void action(Exercise w) {

        exerciseCat.remove(w.getEname());

    }

    public String add() {
        return "addexercise?faces-redirect=true";  // Where to go, navigate 
    }
}
