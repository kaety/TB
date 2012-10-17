/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.tbook.core;

import java.util.List;

/**
 *
 * @author Kristofer
 */
public interface IWorkoutCatalogue extends IDAO<Workout, Long>{
    public List<Workout> getByOwner(TBookUser reciever);
    public Workout ownersNextWorkout(TBookUser owner);
}

