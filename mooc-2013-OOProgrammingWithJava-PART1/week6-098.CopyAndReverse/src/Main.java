
import java.util.Arrays;



public class Main {

    public static int[] copy(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
    
    public static int[] reverseCopy(int[] array) {
        int[] reverseCopy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverseCopy[i] = array[array.length - 1 - i];
        }
        return reverseCopy;
    }
    
    public static void main(String[] args) {
        // write testcode here
        int[] original = {1, 2, 3, 4};
        int[] copied = copy(original);
        
        copied[0] = 99;
        
        int[] reversed = reverseCopy(original);
        
        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copied: " + Arrays.toString(copied));
        System.out.println("Reversed copy: " + Arrays.toString(reversed));
        
    }
    
}
