
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class ShoppingBasket {
    private Map<String, Purchase> basket;
    
    public ShoppingBasket() {
        this.basket = new HashMap<String, Purchase>();
    }
    
    public void add(String product, int price) {
        if (this.basket.containsKey(product)) {
            this.basket.get(product).increaseAmount();
        } else {
            this.basket.put(product, new Purchase(product, 1, price));
        }
    }
    
    public int price() {
        int totalPrice = 0;
        for (Purchase product : this.basket.values()) {
            totalPrice += product.price();
        }
        return totalPrice;
    }
    
    public void print() {
        for (Purchase product : this.basket.values()) {
            System.out.println(product);
        }
    }
}
