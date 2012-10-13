/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.tbok;

import edu.chl.tbook.*;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Andreas
 */
public class TestTBook {
    
    IUserCatalogue uc = UserCatalogue.newInstance("tbook_pu_test");
    IExerciseCatalogue ec = ExerciseCatalogue.newInstance("tbook_pu_test");
    IWorkoutCatalogue wc = WorkoutCatalogue.newInstance("tbook_pu_test");
    IMessageCatalogue mc = MessageCatalogue.newInstance("tbook_pu_test");
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
}
