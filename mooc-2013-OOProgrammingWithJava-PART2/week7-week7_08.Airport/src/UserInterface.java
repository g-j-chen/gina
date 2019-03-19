
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
public class UserInterface {
    private Airport airport;
    private Scanner reader;
    
    public UserInterface(Airport airport, Scanner reader) {
        this.airport = airport;
        this.reader = reader;
    }
    
    public void start() {
        System.out.println("Airport panel");
        System.out.println("-------------------");
        
        while (true) {
            airportChooseOperation();
            
            String command = reader.nextLine();
         
            if (command.equals("1")) {
                addAirplane();
            } else if (command.equals("2")) {
                addFlight();
            } else if (command.equals("x")) {
                break;
            }
        }
        
        System.out.println("Flight service");
        System.out.println("---------------------");
        
        while (true) {
            flightServiceOperation();
            
            String command = reader.nextLine();
            
            if (command.equals("1")) {
                this.airport.printPlanes();
            } else if (command.equals("2")) {
                this.airport.printFlights();
            } else if (command.equals("3")) {
                printFlightInfo();
            } else if (command.equals("x")) {
                break;
            }
            
            
        }
    }
    
    public void airportChooseOperation() {
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
    }
    
    public void addAirplane() {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        this.airport.addPlane(planeID, capacity);
    }
    
    public void addFlight() {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String depCode = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String arrCode = reader.nextLine();
        this.airport.addFlight(planeID, new Flight(depCode, arrCode));
    }
    
    public void flightServiceOperation() {
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");
    }
    
    public void printFlightInfo() {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        this.airport.printPlaneInfo(planeID);
    }
}
