
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class SortAgainstSuitAndValue implements Comparator<Card>{
    
    @Override
    public int compare(Card card1, Card card2) {
        int i = card1.getSuit() - card2.getSuit();
        if (i == 0) {
            return card1.getValue() - card2.getValue();
    }
        return i;
        
    }
}
