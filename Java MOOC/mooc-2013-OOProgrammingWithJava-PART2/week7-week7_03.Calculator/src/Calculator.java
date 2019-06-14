/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Calculator {
    private Reader reader;
    private int numberOfCalculations;
    
    public Calculator() {
        reader = new Reader();
        numberOfCalculations = 0;
    }
    
    public void start() {
        while(true) {
            System.out.println("Command:");
            String command = reader.readString();
            
            if (command.equals("end")) {
                break;
            }
            
            if (command.equals("sum")) {
                sum();
                numberOfCalculations++;
            } else if (command.equals("difference")) {
                difference();
                numberOfCalculations++;
            } else if (command.equals("product")) {
                product();
                numberOfCalculations++;
            }
        }
        statistics();
    }
    
    private void sum() {
        int[] values = getValues();
        int sum = values[0] + values[1];
        System.out.println("Sum of the values: " + sum);
    }
    
    private void difference() {
        int[] values = getValues(); 
        int difference = values[0] - values[1];
        System.out.println("Difference of the values: " + difference);
    }
    
    private void product() {
        int[] values = getValues();        
        int product = values[0] * values[1];
        System.out.println("Product of the values: " + product);
    }
    
    private void statistics() {
        System.out.println("Calculations done: " + this.numberOfCalculations);
    }
    
    private int[] getValues() {
        int[] values = new int[2];
        
        System.out.print("Value 1: ");
        values[0] = reader.readInteger();
        System.out.print("Value 2: ");
        values[1] = reader.readInteger();
        
        return values;
    } 
}
