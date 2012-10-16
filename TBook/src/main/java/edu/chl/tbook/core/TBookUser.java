
package edu.chl.tbook.core;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class TBookUser extends Subject implements Serializable {
    
 /*   @Id
    @Column(nullable=false)
    private String userName;
    @Column(nullable=false) 
    private String passWord; */
    private String fName,lName, eMail;
    
    public TBookUser(){
        
    }
    
    public TBookUser(String userName, String passWord, String eMail){
        super(userName,passWord);
      //  this.userName = userName;
        this.eMail = eMail;
      //  this.passWord = passWord;
        addGroup(SubjectGroup.USER);
    }
    
    public TBookUser(String userName, String passWord, String eMail, String fName, String lName){
        super(userName,passWord);
     //   this.userName = userName;
        this.eMail = eMail;
     //   this.passWord = passWord;
        this.fName = fName;
        this.lName = lName;
        addGroup(SubjectGroup.USER);
    }

    public String getUserName() {
        return getLogin();
    }

  /*  public void setUserName(String userName) {
        this.userName = userName;
    }*/

    public String getPassWord() {
        return getPasswd();
    }
/*
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }*/

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
