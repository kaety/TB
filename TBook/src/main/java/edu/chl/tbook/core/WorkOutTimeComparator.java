/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.tbook.core;

import java.util.Comparator;

/**
 *
 * @author Kristofer
 */
public class WorkOutTimeComparator implements Comparator<Workout> {
    @Override
    public int compare(Workout o1, Workout o2) {
        return o1.getWorkoutTime().compareTo(o2.getWorkoutTime());
    }}