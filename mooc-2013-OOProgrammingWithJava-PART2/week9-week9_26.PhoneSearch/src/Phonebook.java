
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Phonebook {
    private Map<String, Person> byName;
    private Map<String, Person> byPhoneNumber;
    
    public Phonebook() {
        this.byName = new TreeMap<String, Person>();
        this.byPhoneNumber = new HashMap<String, Person>();
    }
    
    public void addPerson(String name) {
        if(!getPerson(name)) {
            Person n = new Person(name);
            byName.put(name, n);
        }
    }
    
    /**
     *
     * @param name
     * @return
     */
    public Boolean getPerson(String name) {
        return byName.containsKey(name);
    }
    
    public void addPhoneNumber(String name, String newPhoneNumber) {
        if(!getPerson(name)) {
            addPerson(name);
        }
        byName.get(name).addPhoneNumber(newPhoneNumber);
        byPhoneNumber.put(newPhoneNumber, byName.get(name));
    }
    
    public void addAddress(String name, String street, String city) {
        if(!getPerson(name)) {
            addPerson(name);
        }
        Person p = byName.get(name);
        p.addStreet(street);
        p.addCity(city);
    }
    
    public void removePerson(String name) {
        Person p = byName.get(name);        
        for(String phoneNo : p.getPhoneNumbers()) {
            byPhoneNumber.remove(phoneNo);
        }
        byName.remove(name);
    }
    
    public String getNumberFromName(String name, int spaces) {
        String numbers = "";
        String whiteSpaces = "";
        for(int i = 0; i < spaces; i++) {
            whiteSpaces += " ";
        }
        if(!getPerson(name)) {
            return null;
        } else {
            ArrayList<String> phoneList = byName.get(name).getPhoneNumbers();
            if(phoneList.isEmpty()) {
                return null;
            }
            for(int i = 0; i < phoneList.size() - 1; i++) {
                numbers += whiteSpaces + phoneList.get(i) + "\n";
            }
            numbers = numbers + whiteSpaces + phoneList.get(phoneList.size() - 1);
            return numbers;
        }
    }
    
    public String getNameFromNumber(String number) {
        String nameFromNumber;
        if(byPhoneNumber.get(number) == null) {
            return null;
        } else {
            nameFromNumber = byPhoneNumber.get(number).getName();
        }
        return nameFromNumber;
    }
    
    public String getAddress(String name) {
        String address;
        if(!getPerson(name)) {
            return null;
        } else if(byName.get(name).getAddress().isEmpty()) {
            return null;
        } else {
            address = byName.get(name).getAddress();
        }
        return address;
    }
    
    public List<Person> filteredListing(String string) {
        List<Person> resultList = new ArrayList<Person>();
        for(Person p : byName.values()) {
            if(p.getName().contains(string) || p.getAddress().contains(string)) {
                resultList.add(p);
            }
        }
        return resultList;
    }  

}
