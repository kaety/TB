/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.tbok;

import edu.chl.tbook.IUserCatalogue;
import edu.chl.tbook.TBookUser;
import edu.chl.tbook.UserCatalogue;
import org.junit.Test;

/**
 *
 * @author Andreas
 */
public class TestUserCatalogue {
    
    @Test
    public void testAdd(){
        IUserCatalogue uc = UserCatalogue.newInstance("tbok_pu");
        TBookUser u = new TBookUser("Loef","abc123","e@mail.com");
        uc.add(u);
    }
}
