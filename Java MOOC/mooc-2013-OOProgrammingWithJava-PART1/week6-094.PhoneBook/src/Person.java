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
    private String phoneNumber;
    
    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getNumber() {
        return this.phoneNumber;
    }
    
    public void changeNumber(String newNumber) {
        this.phoneNumber = newNumber;
    }
    
    @Override
    public String toString() {
        return this.name + "  number: " + this.phoneNumber;
    }
}
