
public class Main {

    public static void main(String[] args) {
        // write test code here
              
        CashRegister unicafeExactum = new CashRegister();
        System.out.println(unicafeExactum);
        
        LyyraCard cardOfJim = new LyyraCard(2);
        
        System.out.println("The card balance: " + cardOfJim.balance() + " euros");
        
        boolean succeeded = unicafeExactum.payGourmet(cardOfJim);
        System.out.println("Payment success " + succeeded);
        
        unicafeExactum.loadMoneyToCard(cardOfJim, 100);
        
        succeeded = unicafeExactum.payGourmet(cardOfJim);
        System.out.println("Payment success " + succeeded);
        
        System.out.println("The card balance " + cardOfJim.balance() + " euros");
        
        System.out.println(unicafeExactum);
    }
    
    
    
}

