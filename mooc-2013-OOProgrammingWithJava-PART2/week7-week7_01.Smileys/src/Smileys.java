
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String characterString) {
        int lengthOfSmileys = characterString.length();
        int numberOfSmileys = (lengthOfSmileys +1) / 2 + 3;
        
        smileyLine(numberOfSmileys);
        
        if (lengthOfSmileys % 2 == 0) {
            System.out.println(":) " + characterString + " :)");
        } else {
            System.out.println(":) " + characterString + "  :)");
        }     
        
        smileyLine(numberOfSmileys);
        
    }
        
    private static void smileyLine(int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(":)");
        }
        System.out.println();
    }

    
    
    
    

}
