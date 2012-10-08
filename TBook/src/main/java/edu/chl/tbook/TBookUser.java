
package edu.chl.tbook;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class TBookUser implements Serializable {
    
    @Id
    @Column(nullable=false)
    private String userName;
    @Column(nullable=false)
    private String passWord;
    private String fName,lName, eMail;
    
    public TBookUser(){
        
    }
    
    public TBookUser(String userName, String passWord, String eMail){
        this.userName = userName;
        this.eMail = eMail;
        this.passWord = passWord;
    }
    
    public TBookUser(String userName, String passWord, String eMail, String fName, String lName){
        this.userName = userName;
        this.eMail = eMail;
        this.passWord = passWord;
        this.fName = fName;
        this.lName = lName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
