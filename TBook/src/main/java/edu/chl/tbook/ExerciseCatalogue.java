
package edu.chl.tbook;

import java.util.*;
import javax.persistence.*;

public class ExerciseCatalogue extends AbstractDAO<Exercise, String> implements IExerciseCatalogue {

    private ExerciseCatalogue(String puName) {
        super(Exercise.class, puName);
    } 
    
    public static IExerciseCatalogue newInstance(String puName){
        return new ExerciseCatalogue(puName);
    }
}
