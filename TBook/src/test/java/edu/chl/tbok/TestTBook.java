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
    TBookUser u1 = new TBookUser("User1", "abc123", "e@mail.com");
    TBookUser u2 = new TBookUser("User2", "abc123", "e@mail.com");
    TBookUser u3 = new TBookUser("User3", "abc123", "e@mail.com");
    TBookUser u4 = new TBookUser("User4", "abc123", "e@mail.com");
    TBookUser u5 = new TBookUser("User5", "abc123", "e@mail.com");
    TBookUser u6 = new TBookUser("User6", "abc123", "e@mail.com");
    TBookUser u7 = new TBookUser("User7", "abc123", "e@mail.com");
    TBookUser u8 = new TBookUser("User8", "abc123", "e@mail.com");

    @Test
    public void testAddFindUser() {
        uc.add(u1);
        uc.add(u2);
        TBookUser uf = uc.find("User1");
        Assert.assertTrue(uf.getUserName().equals("User1"));
        uc.remove(u1.getLogin());
        uc.remove(u2.getLogin());
    }

    @Test
    public void testAddFindMessage() {
        uc.add(u3);
        uc.add(u4);

        TBookMessage m1 = new TBookMessage(u3, u4, "Test1");
        TBookMessage m2 = new TBookMessage(u3, u4, "Test2");
        TBookMessage m3 = new TBookMessage(u4, u3, "Test3");
        mc.add(m1);
        mc.add(m2);
        mc.add(m3);
        List<TBookMessage> mf = mc.getByReciever(u4);

        for (TBookMessage m : mf) {
            System.out.println("From: " + m.getFromUser().getUserName() + " To:" + m.getToUser().getUserName() + " Message:" + m.getText());
        }

        mf = mc.getByReciever(u3);

        for (TBookMessage m : mf) {
            System.out.println("From: " + m.getFromUser().getUserName() + " To:" + m.getToUser().getUserName() + " Message:" + m.getText());
        }
        System.out.println(mf.size());
        Assert.assertTrue(mf.size() == 1);
        uc.remove(u3.getLogin());
        uc.remove(u4.getLogin());
    }

    @Test
    public void testAddFindExerciseAndWorkout() {
        Exercise e1 = new Exercise("Knäböj", "http://www.muscles.se/wp-content/uploads/2008/03/knaboj-utforande.gif", "Ben");
        Exercise e2 = new Exercise("Utfall", "http://www.muscles.se/wp-content/uploads/2008/03/utfall.gif", "Ben");
        Exercise e3 = new Exercise("Sittande vadpress", "http://www.muscles.se/wp-content/uploads/2008/03/sittande-vadpress.gif", "Vader");
        Exercise e4 = new Exercise("Militärpress", "http://www.muscles.se/wp-content/uploads/2008/03/militarpress.gif", "Axlar");
        Exercise e5 = new Exercise("Hantellyft åt sidan", "http://www.muscles.se/wp-content/uploads/2008/03/hantellyft-at-sidan.gif", "Axlar");
        Exercise e6 = new Exercise("Upprätt rodd", "http://www.muscles.se/wp-content/uploads/2008/07/uppratt-rodd.jpg", "Axlar");
        Exercise e7 = new Exercise("Marklyft", "http://www.muscles.se/wp-content/uploads/2008/03/marklyft.gif", "Rygg");
        Exercise e8 = new Exercise("Chins", "http://www.muscles.se/wp-content/uploads/2008/03/chins.gif", "Rygg");
        Exercise e9 = new Exercise("Enhands hantelrodd", "http://www.muscles.se/wp-content/uploads/2008/03/hantelrodd.gif", "Rygg");
        Exercise e10 = new Exercise("Good mornings", "http://www.muscles.se/wp-content/uploads/2008/07/good-mornings.gif", "Rygg");
        Exercise e11 = new Exercise("Kickbacks", "http://www.muscles.se/wp-content/uploads/2008/03/kickbacks.gif", "Triceps");
        Exercise e12 = new Exercise("Dips", "http://www.muscles.se/wp-content/uploads/2008/03/dips.gif", "Triceps");
        Exercise e13 = new Exercise("Koncentrationscurl", "http://www.muscles.se/wp-content/uploads/2008/03/koncentrationscurl.gif", "Biceps");
        Exercise e14 = new Exercise("Skivstångscurl", "http://www.muscles.se/wp-content/uploads/2008/03/skivstangscurl.gif", "Biceps");
        Exercise e15 = new Exercise("Bänkpress", "http://www.muscles.se/wp-content/uploads/2008/03/test2.gif", "Bröst");
        Exercise e16 = new Exercise("Lutande hantelpress", "http://www.muscles.se/wp-content/uploads/2009/02/lutande-hantelpress.jpg", "Bröst");
        Exercise e17 = new Exercise("Flyes", "http://www.muscles.se/wp-content/uploads/2008/03/hantelflyes.gif", "Bröst");
        Exercise e18 = new Exercise("Hängande benlyft", "http://www.muscles.se/wp-content/uploads/2009/02/magovning4.jpg", "Mage");
        Exercise e19 = new Exercise("Situps/crunches", "http://www.muscles.se/wp-content/uploads/2009/02/situps.jpg", "Mage");
        ec.add(e1);
        ec.add(e2);
        ec.add(e3);
        ec.add(e4);
        ec.add(e5);
        ec.add(e6);
        ec.add(e7);
        ec.add(e8);
        ec.add(e9);
        ec.add(e10);
        ec.add(e11);
        ec.add(e12);
        ec.add(e13);
        ec.add(e14);
        ec.add(e15);
        ec.add(e16);
        ec.add(e17);
        ec.add(e18);
        ec.add(e19);
        Exercise ef = ec.find(e1.getEname());
        List<Exercise> efs = ec.getAll();
        Assert.assertTrue(efs.size() == 19 && ef.getDescription().equals(e1.getDescription()));

        uc.add(u5);
        efs = ec.getAll();
        efs.remove(2);
        Workout w1 = new Workout(u5, efs, "eftermiddagspass", Calendar.getInstance().getTimeInMillis() + 1350551775);
        Workout w2 = new Workout(u5, efs, "eftermiddagspass", Calendar.getInstance().getTimeInMillis() + 1350551775);
        wc.add(w1);
        wc.add(w2);
        List<Workout> wf = wc.getByOwner(u5);
        wc.remove(w1.getId());
        efs = ec.getAll();
        System.out.println(wf.size());
        System.out.println(efs.size());
        Assert.assertTrue(wf.size() == 2 && efs.size() == 19);
        uc.remove(u5.getLogin());
    }
}
