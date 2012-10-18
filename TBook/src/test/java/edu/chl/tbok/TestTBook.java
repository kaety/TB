/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.tbok;

import edu.chl.tbook.core.IUserCatalogue;
import edu.chl.tbook.core.UserCatalogue;
import edu.chl.tbook.core.ExerciseCatalogue;
import edu.chl.tbook.core.IMessageCatalogue;
import edu.chl.tbook.core.WorkoutCatalogue;
import edu.chl.tbook.core.IWorkoutCatalogue;
import edu.chl.tbook.core.TBookMessage;
import edu.chl.tbook.core.Workout;
import edu.chl.tbook.core.MessageCatalogue;
import edu.chl.tbook.core.Exercise;
import edu.chl.tbook.core.IExerciseCatalogue;
import edu.chl.tbook.core.TBookUser;
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
    
    
    TBookUser u1 = new TBookUser("User1","abc123","e@mail.com");
    TBookUser u2 = new TBookUser("User2","abc123","e@mail.com");
    TBookUser u3 = new TBookUser("User3","abc123","e@mail.com");
    TBookUser u4 = new TBookUser("User4","abc123","e@mail.com");
    TBookUser u5 = new TBookUser("User5","abc123","e@mail.com");
    TBookUser u6 = new TBookUser("User6","abc123","e@mail.com");
    TBookUser u7 = new TBookUser("User7","abc123","e@mail.com");
    TBookUser u8 = new TBookUser("User8","abc123","e@mail.com");
    
    
    
    @Test
    public void testAddFindUser(){
        uc.add(u1);
        uc.add(u2);
        TBookUser uf = uc.find("User1");
        Assert.assertTrue(uf.getUserName().equals("User1"));
        uc.remove(u1.getLogin());
        uc.remove(u2.getLogin());
    }
    
    @Test
    public void testAddFindMessage(){
        uc.add(u3);
        uc.add(u4);
        
        TBookMessage m1 = new TBookMessage(u3,u4,"Test1");
        TBookMessage m2 = new TBookMessage(u3,u4,"Test2");
        TBookMessage m3 = new TBookMessage(u4,u3,"Test3");
        mc.add(m1);
        mc.add(m2);
        mc.add(m3);
        List<TBookMessage> mf = mc.getByReciever(u4);
        
        for (TBookMessage m : mf){
            System.out.println("From: "+m.getFromUser().getUserName()+" To:"+m.getToUser().getUserName()+" Message:"+m.getText());
        }
        
        mf = mc.getByReciever(u3);
        
        for (TBookMessage m : mf){
            System.out.println("From: "+m.getFromUser().getUserName()+" To:"+m.getToUser().getUserName()+" Message:"+m.getText());
        }
        
        Assert.assertTrue(mf.size() == 1);
        uc.remove(u3.getLogin());
        uc.remove(u4.getLogin());
    }
    
    @Test
    public void testAddFindExerciseAndWorkout(){
        Exercise e1 = new Exercise("Skatan","","Vifta med armarna");
        Exercise e2 = new Exercise("Fisk på land","","Ligg ner och sprattla runt");
        Exercise e3 = new Exercise("Test1","","Gör vad du vill");
        ec.add(e1);
        ec.add(e2);
        ec.add(e3);
        Exercise ef = ec.find(e1.geteName());
        List<Exercise> efs = ec.getAll();
        Assert.assertTrue(efs.size() == 3 && ef.getDescription().equals(e1.getDescription()));
        
        uc.add(u5);
        efs = ec.getAll();
        efs.remove(2);
        Workout w1 = new Workout(u5,efs,"eftermiddagspass",Calendar.getInstance().getTimeInMillis()+1350551775);
        Workout w2 = new Workout(u5,efs,"eftermiddagspass",Calendar.getInstance().getTimeInMillis()+1350551775);
        wc.add(w1);
        wc.add(w2);
        List<Workout> wf = wc.getByOwner(u5);
        wc.remove(w1.getId());
        efs = ec.getAll();
        Assert.assertTrue(wf.size() == 2 && efs.size() == 3);
        uc.remove(u5.getLogin());
    }
}
