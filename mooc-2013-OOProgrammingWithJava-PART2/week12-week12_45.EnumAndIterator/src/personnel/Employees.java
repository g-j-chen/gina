/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ginaj
 */
public class Employees {
    private List<Person> employeesList;
    
    public Employees() {
        this.employeesList = new ArrayList<Person>();
    }
    
    public void add(Person person) {
        employeesList.add(person);
    }
    
    public void add(List<Person> persons) {
        for(Person p : persons) {
            employeesList.add(p);
        }
    }
    
    public void print() {
        Iterator<Person> iterator = employeesList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = employeesList.iterator();
        while(iterator.hasNext()) {
            Person p = iterator.next();
            if(p.getEducation().equals(education)) {
                System.out.println(p);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = employeesList.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getEducation().equals(education)) {
                iterator.remove();
            }
        }
    }
    
}
