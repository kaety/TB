
package edu.chl.tbook;

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
}
