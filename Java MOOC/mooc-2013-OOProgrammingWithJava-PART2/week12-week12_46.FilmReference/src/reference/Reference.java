/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;

/**
 *
 * @author ginaj
 */
public class Reference {
    
    private RatingRegister reg;
    
    public Reference(RatingRegister reg) {
        this.reg = reg;
    }
    
    public Film recommendFilm(Person person) {
        if(reg.getPersonalRatings(person).isEmpty()) {
            Map filmRatings = new LinkedHashMap();
            filmRatings = reg.filmRatings();

            List<Film> films = new ArrayList<Film>();
            for (Iterator it = filmRatings.keySet().iterator(); it.hasNext();) {
                Film f = (Film) it.next();
                films.add(f);
            }
            Collections.sort(films, new FilmComparator(filmRatings));

            return films.get(0);
        }
        
        List<Person> reviewers = new ArrayList<Person>();
        reviewers = reg.reviewers();
        if(reviewers.contains(person)) {
            reviewers.remove(person);
        }
        
        Map<Film, Rating> personsRatings = new LinkedHashMap();
        personsRatings = reg.getPersonalRatings(person);
        
        Map<Film, Rating> reviewersRatings = new LinkedHashMap();
        
        
        
        Map<Person, Integer> similarPerson = new LinkedHashMap();
        
        for(Person reviewer : reviewers) {
            int similarity = 0;
            reviewersRatings = reg.getPersonalRatings(reviewer);
            for(Film f : reviewersRatings.keySet()) {
                if(personsRatings.containsKey(f)) {
                    similarity += (personsRatings.get(f).getValue() * reviewersRatings.get(f).getValue()); 
                }
            }
            similarPerson.put(reviewer, similarity);
        }
        
        Collections.sort(reviewers, new PersonComparator(similarPerson));

        Person mostSimilar = reviewers.get(0);
        
        List<Film> recommendations = new ArrayList<Film>();
        Map<Film, Rating> bestMatchReviewer = new LinkedHashMap();
        bestMatchReviewer = reg.getPersonalRatings(mostSimilar);
        
        for(Film f : bestMatchReviewer.keySet()) {
            if(!personsRatings.containsKey(f)) {
                    recommendations.add(f);
            }
        }

        Film recommendedFilm = null;
        
        int s = 0;
        for(Film f : recommendations) {
            if(bestMatchReviewer.get(f).equals(Rating.BAD) || 
                    bestMatchReviewer.get(f).equals(Rating.MEDIOCRE) || 
                    bestMatchReviewer.get(f).equals(Rating.NEUTRAL)) {
                s++;
            }
            if(bestMatchReviewer.get(f).equals(Rating.GOOD)) {
                recommendedFilm = f;
            } else if(bestMatchReviewer.get(f).equals(Rating.FINE)) {
                recommendedFilm = f;
            }
        }
        
        if(s == recommendations.size()) {
            return null;
        }
        
        if(recommendations.isEmpty()) {
            return null;
        }else {
            return recommendedFilm;
        }
        
    }

}
