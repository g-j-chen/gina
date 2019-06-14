
public class Main {

    public static void main(String[] args) {
        // write some test code here
        
        Card first = new Card(2, Card.DIAMONDS);
        Card second = new Card(14, Card.CLUBS);
        Card third = new Card(12, Card.HEARTS);
        
        //System.out.println(first.compareTo(second));
        //System.out.println(second.compareTo(third));
        
        Hand hand = new Hand();
        hand.add(first);
        hand.add(second);
        hand.add(third);
        hand.add(new Card(2, Card.SPADES));
        
        
        hand.add(new Card(11, Card.DIAMONDS));
        hand.add(new Card(11, Card.CLUBS));
        hand.add(new Card(11, Card.HEARTS));
        
        hand.sortAgainstSuit();
        
        hand.print();

    }
}
