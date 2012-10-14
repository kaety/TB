/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.tbok;

import edu.chl.tbook.*;
import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Andreas
 */
public class TestTBook {
    
    String pu = "tbook_pu_test";
    
    IUserCatalogue uc = UserCatalogue.newInstance(pu);
    IExerciseCatalogue ec = ExerciseCatalogue.newInstance(pu);
    IWorkoutCatalogue wc = WorkoutCatalogue.newInstance(pu);
    IMessageCatalogue mc = MessageCatalogue.newInstance(pu);
    
    
    TBookUser u1 = new TBookUser("UserOne","abc123","e@mail.com");
    TBookUser u2 = new TBookUser("UserTwo","abc123","e@mail.com");
    
    
    
    @Test
    public void testAddFindUser(){
        uc.add(u1);
        uc.add(u2);
        TBookUser uf = uc.find("UserOne");
        Assert.assertTrue(uf.getUserName().equals("UserOne"));
    }
    
    @Test
    public void testAddFindMessage(){
        TBookMessage m1 = new TBookMessage(u1,u2,"Test1");
        TBookMessage m2 = new TBookMessage(u1,u2,"Test2");
        TBookMessage m3 = new TBookMessage(u2,u1,"Test3");
        mc.add(m1);
        mc.add(m2);
        mc.add(m3);
        List<TBookMessage> mf = mc.getByReciever(u2);
        
        for (TBookMessage m : mf){
            System.out.println("From: "+m.getFromUser().getUserName()+" To:"+m.getToUser().getUserName()+" Message:"+m.getText());
        }
        
        mf = mc.getByReciever(u1);
        
        for (TBookMessage m : mf){
            System.out.println("From: "+m.getFromUser().getUserName()+" To:"+m.getToUser().getUserName()+" Message:"+m.getText());
        }
        
        Assert.assertTrue(mf.size() == 1);
    }
    
    @Test
    public void testAddFindExercise(){
        Exercise e1 = new Exercise("Skatan","","Vifta med armarna");
        Exercise e2 = new Exercise("Fisk på land","","Ligg ner och sprattla runt");
        Exercise e3 = new Exercise("Test1","","Gör vad du vill");
        ec.add(e1);
        ec.add(e2);
        ec.add(e3);
        Exercise ef = ec.find(e1.geteName());
        List<Exercise> efs = ec.getAll();
        Assert.assertTrue(efs.size() == 3 && ef.getDescription().equals(e1.getDescription()));
    }
    
    @Test
    public void testAddFindWorkout(){
        List<Exercise> efs = ec.getAll();
        efs.remove(2);
        Workout w1 = new Workout(u1,efs,"eftermiddagspass",Calendar.getInstance().getTimeInMillis());
        Workout w2 = new Workout(u1,efs,"eftermiddagspass",Calendar.getInstance().getTimeInMillis());
        wc.add(w1);
        wc.add(w2);
        List<Workout> wf = wc.getByOwner(u1);
        wc.remove(w1.getId());
        efs = ec.getAll();
        Assert.assertTrue(wf.size() == 2 && efs.size() == 3);
    }
}
