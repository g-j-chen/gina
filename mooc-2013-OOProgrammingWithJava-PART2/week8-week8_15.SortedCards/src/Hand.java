
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand;
    
    public Hand() {
        hand = new ArrayList<Card>();
    }
    
    public void add(Card card) {
        hand.add(card);
    }
    
    public void print() {
        for (Card c : hand) {
            System.out.println(c);
        }
    }
    
    public void sort() {
        Collections.sort(hand);
    }
    
    @Override
    public int compareTo(Hand hand) {
        int thisTotal = 0;
        int otherTotal = 0;
        
        for (Card c : this.hand) {
            thisTotal += c.getValue();
        }
        for (Card c : hand.hand) {
            otherTotal += c.getValue();
        }
        
        return thisTotal - otherTotal;
    }
    
    public void sortAgainstSuit() {
        Collections.sort(hand, new SortAgainstSuitAndValue());
    }
}
