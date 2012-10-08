package edu.chl.tbook;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum TBook {

    INSTANCE;
    /*private final IProductCatalogue productCatalogue = ProductCatalogue.newInstance("shop_pu");
    private final ICustomerRegistry customerRegistry = CustomerRegistry.newInstance("shop_pu");
    private final IOrderBook orderBook = OrderBook.newInstance("shop_pu");*/

    private TBook() {
        Logger.getAnonymousLogger().log(Level.INFO, "TBook alive {0}", this.hashCode());

    }
    /*
    public ICustomerRegistry getCustomerRegistry() {
        return customerRegistry;
    }

    public IOrderBook getOrderBook() {
        return orderBook;
    }

    public IProductCatalogue getProductCatalogue() {
        return productCatalogue;
    }
    * */
}
