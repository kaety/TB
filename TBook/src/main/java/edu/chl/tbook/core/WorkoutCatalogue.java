
package edu.chl.tbook.core;

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
            String query = "select w from Workout w WHERE w.owner.login = '"+owner.getUserName()+"'";
            TypedQuery<Workout> q = em.createQuery(query, Workout.class);
            workouts = q.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return workouts;
    }
    
    @Override
    public Workout ownersNextWorkout(TBookUser owner){
       ArrayList<Workout> wo = (ArrayList) getByOwner(owner);
       Collections.sort(wo, new WorkOutTimeComparator());
       
       if (wo.isEmpty()){
           return null;
       }
       else{
           for(Workout w:wo){
               
               if(w.getWorkoutTime() >System.currentTimeMillis()){
                   return w;
               }
               
           }
        return null;   
       }
    }
   
    
}
