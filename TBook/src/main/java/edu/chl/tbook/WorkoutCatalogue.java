
package edu.chl.tbook;

import java.util.*;
import javax.persistence.*;

public class WorkoutCatalogue extends AbstractDAO<Workout, Long> implements IWorkoutCatalogue {

    private WorkoutCatalogue(String puName) {
        super(Workout.class, puName);
    } 
    
    public static IWorkoutCatalogue newInstance(String puName){
        return new WorkoutCatalogue(puName);
    }

    @Override
    public List<Workout> getByOwner(TBookUser owner) {
        EntityManager em = null;
        List<Workout> workouts = null;
        try {
            em = getEntityManager();
            String query = "select w from Workout w WHERE w.owner.userName = '"+owner.getUserName()+"'";
            TypedQuery<Workout> q = em.createQuery(query, Workout.class);
            workouts = q.getResultList();
        } catch (Exception ex) {
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return workouts;
    }
}
