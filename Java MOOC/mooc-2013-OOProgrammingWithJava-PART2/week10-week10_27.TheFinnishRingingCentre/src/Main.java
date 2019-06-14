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
        RingingCentre rc = new RingingCentre();
        
        rc.observe(new Bird("Rose Starling", "Sturnus roseus", 2012), "Arabia");
        rc.observe(new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012), "Vallila");
        rc.observe(new Bird("European Herring Gull", "Larus argentatus", 2008), "Kump");
        rc.observe(new Bird("Rose Starling", "Sturnus roseus", 2008), "Manner");
        
        rc.observations(new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012));
        rc.observations(new Bird("European Herring Gull", "Larus argentatus", 2008));
        rc.observations(new Bird("European Herring Gull", "Larus argentatus", 1980));
    }
}
