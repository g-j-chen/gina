/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ginaj
 */
public class AverageSensor implements Sensor {
    private List<Sensor> sensorList;
    private List<Integer> measurements;
    
    public AverageSensor() {
        this.sensorList = new ArrayList<Sensor>();
        this.measurements = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional) {
        this.sensorList.add(additional);
    }
    
    @Override
    public boolean isOn() {
        boolean allOn = true;
        for (Sensor s : this.sensorList) {
            if (!s.isOn()) {
                allOn = false;
            }
        }
        return allOn;
    }

    @Override
    public void on() {
        for (Sensor s : this.sensorList) {
            s.on();
        }
    }

    @Override
    public void off() {
        for (Sensor s : this.sensorList) {
            s.off();
        }
    }

    @Override
    public int measure() {
        if (!isOn()) {
            throw new IllegalStateException("Sensors are not on");
        }
        int total = 0;
        for (Sensor s : this.sensorList) {
            total += s.measure();
        }
        int aveMeasure = total / this.sensorList.size();
        this.measurements.add(aveMeasure);
        return aveMeasure;
    }
    
    public List<Integer> readings() {
        return this.measurements;
    }
    
}
