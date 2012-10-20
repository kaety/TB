/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.TBookWeb;

import edu.chl.tbook.core.*;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author klokkan
 */
@Named("messages")
@SessionScoped
public class MessagingBB implements Serializable{

    private IMessageCatalogue messageCat = TBook.INSTANCE.getMessageCatalogue();
    private IUserCatalogue userCat = TBook.INSTANCE.getUserCatalogue();
    
    private String to = "";
    private String text = "";

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public List<TBookMessage> getInbox(){
        String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return messageCat.getByReciever(userCat.find(user));
    }
    
    public List<TBookMessage> getOutbox(){
        String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return messageCat.getBySender(userCat.find(user));
    }
    
    public TBookMessage getMessage(Long id){
        TBookMessage m = messageCat.find(id);
        String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        if (m.getFromUser().getLogin().equals(user) || m.getToUser().getLogin().equals(user)){
            return m;
        }
        return new TBookMessage();
    }
    
    public String send() {    
        String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        TBookUser toUser = userCat.find(to);
        TBookUser fromUser = userCat.find(user);
        if (toUser == null){
             Logger.getAnonymousLogger().log(Level.INFO, "User does not exist");
             FacesMessage facesMessage = new FacesMessage("No user with that name");
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage("messageForm:txtTo",  facesMessage);
        }
        else {

            Logger.getAnonymousLogger().log(Level.INFO, "Sending message \""+text+"\" to "+toUser.getLogin());
            TBookMessage m = new TBookMessage(fromUser, toUser, text);
            messageCat.add(m);
            text = "";
            to = "";
            return "outbox?faces-redirect=true";  // Where to go, navigate 
        }
        return null;
    }
}
