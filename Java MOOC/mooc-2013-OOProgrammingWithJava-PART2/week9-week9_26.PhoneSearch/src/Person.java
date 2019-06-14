
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Person {
    private String name;
    private List<String> phoneNumbers;
    private String street;
    private String city;
    
    public Person(String name) {
        this.name = name;
        this.phoneNumbers = new ArrayList<String>();
    }
    
    public void addPhoneNumber(String phoneNumber) {
        if(!phoneNumbers.contains(phoneNumber)) {
            phoneNumbers.add(phoneNumber);
        }
    }
    
    public void addStreet(String streetName) {
        this.street = streetName;
    }
    
    public void addCity(String cityName) {
        this.city = cityName;
    }
    
    public String getName() {
        return name;
    }
    
    public ArrayList<String> getPhoneNumbers() {
        return (ArrayList<String>) phoneNumbers;
    }
    
    public String getAddress() {
        String address;
        if(street == null || city == null) {
            address = "";
        } else {
            address = street + " " + city;
        }
        return address;
    }
}
