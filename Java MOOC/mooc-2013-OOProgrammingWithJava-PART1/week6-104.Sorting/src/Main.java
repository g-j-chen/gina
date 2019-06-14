import java.util.Arrays;

public class Main {
    public static int smallest(int[] array) {
        int tempSmallest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < tempSmallest) {
                tempSmallest = array[i];
            }
        }
        return tempSmallest;
    }
    
    public static int indexOfTheSmallest(int[] array) {
        int returnValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (smallest(array) == array[i]) {
                returnValue = i;
            }
        }
        return returnValue;
    }
    
    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        int returnValue = index;
        int tempSmallest = array[index];
        for (int i = index; i < array.length; i++) {
            if (array[i] < tempSmallest) {
                tempSmallest = array[i];
                returnValue = i;
            }
        }
        return returnValue;
    }
    
    public static void swap(int[] array, int index1, int index2) {
        int temp1 = array[index1];
        int temp2 = array[index2];
        array[index1] = temp2;
        array[index2] = temp1;
    }
    
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexOfSmallest = indexOfTheSmallestStartingFrom(array, i);
            swap(array, i, indexOfSmallest);
            System.out.println(Arrays.toString(array));
        }
    }
    
    public static void main(String[] args) {
        // write testcode here
        int[] values = {8, 3, 7, 9, 1, 2, 4};
        sort(values);


        
    }

}
