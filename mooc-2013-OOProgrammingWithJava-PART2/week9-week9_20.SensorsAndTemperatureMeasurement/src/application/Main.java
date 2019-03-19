/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author ginaj
 */
public class Main {
    public static void main(String[] args) {
        Sensor kumpula = new Thermometer();       
        Sensor kaisaniemi = new Thermometer();
        Sensor helsinkiVantaa = new Thermometer();
        
        AverageSensor helsinkiArea = new AverageSensor();
        helsinkiArea.addSensor(kaisaniemi);
        helsinkiArea.addSensor(kumpula);
        helsinkiArea.addSensor(helsinkiVantaa);
        
        helsinkiArea.on();
        System.out.println("The temperature in Helsinki area is: " + helsinkiArea.measure() + " degrees");
        System.out.println("The temperature in Helsinki area is: " + helsinkiArea.measure() + " degrees");
        System.out.println("The temperature in Helsinki area is: " + helsinkiArea.measure() + " degrees");
        
        System.out.println("Readings: " + helsinkiArea.readings());
        
    }
}
