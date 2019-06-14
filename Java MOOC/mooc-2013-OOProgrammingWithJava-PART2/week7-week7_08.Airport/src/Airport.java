
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Airport {
    private ArrayList<Planes> planes;
    private HashMap<Planes, Flight> flights;
    
    public Airport() {
        this.planes = new ArrayList<Planes>();
        this.flights = new HashMap<Planes, Flight>();
    }
    
    public void addPlane(String planeID, int capacity) {
        this.planes.add(new Planes(planeID, capacity));
    }
    
    public void addFlight(String planeID, Flight flight) {
        for (Planes p : this.planes) {
            if (p.getID().equals(planeID)) {
                Planes plane = new Planes(p.getID(), p.getCapacity());
                this.flights.put(plane, flight);
            }
        }
    }
        
    public void printPlanes() {
        for (Planes p : this.planes) {
            System.out.println(p.toString());
        }
    }
    
    public void printFlights() {
        for (Planes p : this.flights.keySet()) {
            System.out.println(p.toString() + " " + this.flights.get(p));
        }
    }
    
    public void printPlaneInfo(String planeID) {
        for (Planes p : this.planes) {
            if (p.getID().equals(planeID)) {
                System.out.println(p.toString());
            }
        }
    }
    
}
