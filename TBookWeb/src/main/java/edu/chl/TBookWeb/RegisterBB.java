/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.TBookWeb;

import edu.chl.tbook.core.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author klokkan
 */
@Named("register")
@SessionScoped
public class RegisterBB implements Serializable{

    private IUserCatalogue userCat = TBook.INSTANCE.getUserCatalogue();
    private String fName = "";
    private String lName = "";
    private String uName = "";
    private String passwd = "";
    private String email = "";
    
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lNname) {
        this.lName = lNname;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String action() {     
        TBookUser u = new TBookUser(uName,passwd,email,fName,lName);
        userCat.add(u);
        uName = "";
        passwd = "";
        lName = "";
        fName = "";
        email = "";
        Logger.getAnonymousLogger().log(Level.INFO, "added user {0}", u);
        return "login?faces-redirect=true";  // Where to go, navigate 
    }
    public String cancel(){
        return "login?faces-redirect=true"; 
    }
}
