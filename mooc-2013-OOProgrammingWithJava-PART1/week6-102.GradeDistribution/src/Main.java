
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Main {
 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // implement your program here
        // do not put all to one method/class but rather design a proper structure to your program

        // Your program should use only one Scanner object, i.e., it is allowed to call 
        // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter

        System.out.println("Type exam scores, -1 completes:");
        ExamScores es = new ExamScores();
        while(true) {
            int score = Integer.parseInt(scanner.nextLine());
            if (score == -1) {
                break;
            }
            es.addScore(score);
            }
        
        es.printScoreDistribution();
        es.acceptancePercentage();
    }

}
