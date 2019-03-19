/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author ginaj
 */
public class RatingRegister {
    
    private Map<Film, List<Rating>> ratingRegister;
    private Map<Person, Map<Film, Rating>> personalRating;
    
    public RatingRegister() {
        this.ratingRegister = new LinkedHashMap<Film, List<Rating>>();
        this.personalRating = new LinkedHashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        if(!ratingRegister.containsKey(film)) {
            List<Rating> r = new ArrayList<Rating>();
            r.add(rating);
            ratingRegister.put(film, r);
        } else {
            List<Rating> r = ratingRegister.get(film);
            r.add(rating);
            ratingRegister.put(film, r);
        }
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        if(!personalRating.containsKey(person)) {
            Map ratings = new HashMap();
            ratings.put(film, rating);
            personalRating.put(person, ratings);
        } else {
            Map ratings = personalRating.get(person);
            if(!ratings.containsKey(film)) {
                ratings.put(film, rating);
                personalRating.put(person, ratings);
            }
        }
        addRating(film, rating);
    }
    
    public Rating getRating(Person person, Film film) {
        if(!personalRating.containsKey(person)) {
            return null;
        }
        
        Map personRatings = personalRating.get(person);
        if(personRatings.containsKey(film)) {
            return (Rating) personRatings.get(film);
        }
        return Rating.NOT_WATCHED;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        if(!personalRating.containsKey(person)) {
            return new LinkedHashMap();
        }
        return personalRating.get(person);
    }
    
    public List<Person> reviewers() {
        List<Person> reviewersList = new ArrayList<Person>();
        for(Person p : personalRating.keySet()) {
            reviewersList.add(p);
        }
        return reviewersList;
    }
    
    public List<Rating> getRatings(Film film) {
        return ratingRegister.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return ratingRegister;
    }
}
