
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Storehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;
    
    public Storehouse() {
        this.prices = new HashMap<String, Integer>();
        this.stocks = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stocks.put(product, stock);
    }
    
    public int price(String product) {
        if(this.prices.containsKey(product)) {
            return this.prices.get(product);
        }
        return -99;
    }
    
    public int stock(String product) {
        if(this.stocks.containsKey(product)) {
            return this.stocks.get(product);
        }
        return 0;
    }
    
    public boolean take(String product) {
        boolean canTake = false;
        if (stock(product) > 0) {
            this.stocks.put(product, this.stocks.get(product) - 1);
            canTake = true;
        } else {
            this.stocks.put(product, 0);
            canTake = false;
        }
        return canTake;
    }
    
    public Set<String> products() {
        return this.prices.keySet();
    }
}
