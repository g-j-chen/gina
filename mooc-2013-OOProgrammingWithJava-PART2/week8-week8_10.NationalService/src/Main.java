public class Main {
    public static void main(String[] args) {
        // Test your code here!
        
        CivilService cs = new CivilService();
        System.out.println(cs.getDaysLeft());
        cs.work();
        System.out.println(cs.getDaysLeft());
    }
}
