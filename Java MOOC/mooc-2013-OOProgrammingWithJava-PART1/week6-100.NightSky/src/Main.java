
public class Main {

    public static void main(String[] args) {
        // Test your code here
        NightSky nightSky = new NightSky(8, 4);
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
        System.out.println("");
        
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
    }
}
