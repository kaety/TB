
package edu.chl.tbook.core;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class TBookUser extends Subject implements Serializable {
    
 
    private String fName,lName, eMail;
    
    public TBookUser(){
        
    }
    
    public TBookUser(String userName, String passWord, String eMail){
        super(userName,passWord);
        this.eMail = eMail;
        addGroup(SubjectGroup.USER);
    }
    
    public TBookUser(String userName, String passWord, String eMail, String fName, String lName){
        super(userName,passWord);
        this.eMail = eMail;
        this.fName = fName;
        this.lName = lName;
        addGroup(SubjectGroup.USER);
    }

    public String getUserName() {
        return getLogin();
    }


    public String getPassWord() {
        return getPasswd();
    }

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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    
}
