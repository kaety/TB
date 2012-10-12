package edu.chl.tbook;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum TBook {

    INSTANCE;
    private final IExerciseCatalogue exerciseCatalogue = ExerciseCatalogue.newInstance("tbook_pu");
    private final IWorkoutCatalogue workoutCatalogue = WorkoutCatalogue.newInstance("tbook_pu");
    private final IMessageCatalogue messageCatalogue = MessageCatalogue.newInstance("tbook_pu");
    private final IUserCatalogue userCatalogue = UserCatalogue.newInstance("tbook_pu");

    private TBook() {
        Logger.getAnonymousLogger().log(Level.INFO, "TBook alive {0}", this.hashCode());

    }

    public IUserCatalogue getUserCatalogue() {
        return userCatalogue;
    }
    
    public IExerciseCatalogue getExerciseCatalogue() {
        return exerciseCatalogue;
    }
    
    public IWorkoutCatalogue getWorkoutCatalogue() {
        return workoutCatalogue;
    }
    
    public IMessageCatalogue getMessageCatalogue() {
        return messageCatalogue;
    }
}
