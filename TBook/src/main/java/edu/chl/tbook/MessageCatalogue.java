package edu.chl.tbook;

import java.util.*;
import javax.persistence.*;

public class MessageCatalogue extends AbstractDAO<TBookMessage, Long> implements IMessageCatalogue {

    private MessageCatalogue(String puName) {
        super(TBookMessage.class, puName);
    } 
    
    public static IMessageCatalogue newInstance(String puName){
        return new MessageCatalogue(puName);
    }
}
