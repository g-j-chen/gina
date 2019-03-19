
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
public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister(){
        this.owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        if (this.owners.get(plate) == null) {
            this.owners.put(plate, owner);
            return true;
        }
        return false;
    }
    
    public String get(RegistrationPlate plate) {
        if (this.owners.get(plate) == null) {
            return null;
        }
        return this.owners.get(plate);
    }
    
    public boolean delete(RegistrationPlate plate) {
        if (this.owners.get(plate) != null) {
            this.owners.remove(plate);
            return true;
        }
        return false;
    }
    
    public void printRegistrationPlates() {
        for (RegistrationPlate plate : this.owners.keySet()) {
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> ownerList = new ArrayList<String>();
        for (String owner : this.owners.values()) {
           if (!ownerList.contains(owner)) {
               ownerList.add(owner);
               System.out.println(owner);
           }
        }
    }
    
}
