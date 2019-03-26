/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ginaj
 */
public class Permutations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        
        String[] tempArray = scanner.nextLine().split("\\s+");
        List<Integer> array = new ArrayList<>();
        for (String s : tempArray) {
            int n = Integer.parseInt(s);
            array.add(n);
        }
        
        int repetitions = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> rotations = new ArrayList<>();
        
        while(scanner.hasNextLine()) {
            String st = scanner.nextLine();
            
            if(st.equals("exit")) {
                scanner.close();
                break;
            }
            
            String[] tempRotations = st.split("\\s+");
            List<Integer> subRotation = new ArrayList<>();
            for(String s : tempRotations) {
                int n = Integer.parseInt(s);
                subRotation.add(n - 1);
            }
            rotations.add(subRotation);
        }
        
        permutation(array, rotations, repetitions);
        System.out.println(array);
    }
    
    
    public static List<Integer> permutation(List<Integer> array, List<List<Integer>> rotations, int repetitions) {
        for(int r = 0; r < repetitions; r++) {
            for(int i = 0; i < rotations.size(); i++) {
                List<Integer> subRotation = rotations.get(i);
                List<Integer> storage = new ArrayList<>();
                storage.add(array.get(subRotation.get(0)));

                int lastChangeIndex = subRotation.get(subRotation.size() - 1);
                int temp = array.get(lastChangeIndex);

                for(int j = 0; j < subRotation.size() - 1; j++) {
                    storage.add(array.get(subRotation.get(j + 1)));
                    array.set(subRotation.get(j + 1), storage.get(j));
                }
                array.set(subRotation.get(0), temp);
            }
        }
        
        return array;
    }    
}
