/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Flight {
    private String departureCode;
    private String arrivalCode;
    
    public Flight(String departureCode, String arrivalCode) {
        this.departureCode = departureCode;
        this.arrivalCode = arrivalCode;
    }
    
    public String toString() {
        return "(" + this.departureCode + "-" + this.arrivalCode + ")";
    }
}
