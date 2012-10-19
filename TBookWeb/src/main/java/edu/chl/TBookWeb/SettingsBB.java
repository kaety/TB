/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.TBookWeb;

import edu.chl.tbook.core.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named("settings")
@RequestScoped
public class SettingsBB implements Serializable {

    private IUserCatalogue userCat = TBook.INSTANCE.getUserCatalogue();
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    private String fName = "";
    private String lName = "";
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

    public void setlName(String lName) {
        this.lName = lName;
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
        TBookUser u = new TBookUser(request.getRemoteUser(), passwd, email, fName, lName);
        userCat.update(u);
        passwd = "";
        lName = "";
        fName = "";
        email = "";
        Logger.getAnonymousLogger().log(Level.INFO, "updated user {0}", u);
        return "index?faces-redirect=true";  // Where to go, navigate 
    }
}
