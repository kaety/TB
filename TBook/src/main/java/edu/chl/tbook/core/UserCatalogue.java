
package edu.chl.tbook.core;

/**
 * All products
 * @author hajo
 */
public final class UserCatalogue extends AbstractDAO<TBookUser, String> implements IUserCatalogue {

    private UserCatalogue(String puName) {
        super(TBookUser.class, puName);
    }
   
    public static UserCatalogue newInstance(String puName){
        return new UserCatalogue(puName);
    }   
    
    @Override
    public void remove(String id){
        System.out.println("Trying to remove user, not allowed!");
    }
}
