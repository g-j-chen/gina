/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author ginaj
 */
public class Thermometer implements Sensor {
    private boolean isOn;
    
    public Thermometer() {
        isOn = false;
    }
    
    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void on() {
        isOn = true;
    }

    @Override
    public void off() {
        isOn = false;
    }

    @Override
    public int measure() {
        if (false == this.isOn) {
            throw new IllegalStateException("Thermometer is off");
        }
        Random random = new Random();
        return random.nextInt(61) - 30;
    }
    
}
