/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import reference.domain.Person;

/**
 *
 * @author ginaj
 */
public class PersonComparator implements Comparator<Person> {
    
    private Map<Person, Integer> peopleIdentities;
    
    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }
    

    @Override
    public int compare(Person p1, Person p2) {
        if(peopleIdentities.get(p1) == peopleIdentities.get(p2)) {
            return 0;
        } else if(peopleIdentities.get(p1) > peopleIdentities.get(p2)) {
            return -1;
        } else {
            return 1;
        }
    }
}