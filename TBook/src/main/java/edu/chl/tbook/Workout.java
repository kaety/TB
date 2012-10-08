package edu.chl.tbook;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Workout implements Serializable{
    
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    private TBookUser owner;
    private List<Exercise> ex;
    private String name;
    private Long workoutTime;

    public Workout() {
    }

    public Workout(List<Exercise> ex, String name, Long workoutTime) {
        this.ex = ex;
        this.name = name;
        this.workoutTime = workoutTime;
    }

    public Workout(String name, Long workoutTime) {
        this.name = name;
        this.workoutTime = workoutTime;
        this.ex =new ArrayList<>();
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(Long workoutTime) {
        this.workoutTime = workoutTime;
    }

    public List<Exercise> getEx() {
        return ex;
    }

    public void setEx(List<Exercise> ex) {
        this.ex = ex;
    }
    
    
}
