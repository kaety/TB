
package edu.chl.tbook;

import java.util.*;
import javax.persistence.*;

public class WorkoutCatalogue extends AbstractDAO<Workout, String> implements IWorkoutCatalogue {

    private WorkoutCatalogue(String puName) {
        super(Workout.class, puName);
    } 
    
    public static IWorkoutCatalogue newInstance(String puName){
        return new WorkoutCatalogue(puName);
    }
}
