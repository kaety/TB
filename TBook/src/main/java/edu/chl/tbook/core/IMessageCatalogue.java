/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.tbook.core;

import java.util.List;

/**
 *
 * @author Kristofer
 */
public interface IMessageCatalogue extends IDAO<TBookMessage, Long>{
    public List<TBookMessage> getByReciever(TBookUser reciever);
    public List<TBookMessage> getBySender(TBookUser sender);
}
