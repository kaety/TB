/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.tbook.core;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Andreas
 */
@Entity
public class TBookMessage implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade=CascadeType.MERGE)
    private TBookUser fromUser = null;
    @OneToOne(cascade=CascadeType.MERGE)
    private TBookUser toUser = null;
    private Workout toWorkout = null; //EXTRA GREJ
    private Long postTime;
    private String text;
    
    public TBookMessage(){
        
    }
    
    public TBookMessage(TBookUser from, TBookUser messageTo, String message){
        this.fromUser = from;
        this.toUser = messageTo;
        this.text = message;
        Calendar cal = Calendar.getInstance();
        postTime = cal.getTimeInMillis();
    }
    
    public TBookMessage(TBookUser from, Workout commentTo, String message){
        this.fromUser = from;
        this.toWorkout = commentTo;
        this.text = message;
        Calendar cal = Calendar.getInstance();
        postTime = cal.getTimeInMillis();
    }

    public TBookUser getFromUser() {
        return fromUser;
    }
    
    public TBookUser getToUser() {
        return toUser;
    }

    public void setFromUser(TBookUser fromUser) {
        this.fromUser = fromUser;
    }

    public Long getPostTime() {
        return postTime;
    }

    public void setPostTime(Long postTime) {
        this.postTime = postTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public Long getId(){
        return id;
    }
    
    
}
