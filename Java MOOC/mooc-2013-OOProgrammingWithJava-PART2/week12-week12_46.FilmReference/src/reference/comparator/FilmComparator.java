/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author ginaj
 */
public class FilmComparator implements Comparator<Film> {
    
    private Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film f1, Film f2) {        
        double f1Ratings = 0;
        for(Rating r : ratings.get(f1)) {
            f1Ratings += r.getValue();
        }
        f1Ratings /= ratings.get(f1).size();
        int ave1 = (int) f1Ratings;
        
        double f2Ratings = 0;
        for(Rating r : ratings.get(f2)) {
            f2Ratings += r.getValue();
        }
        f2Ratings /= ratings.get(f2).size();
        int ave2 = (int) f2Ratings;
        
        if(ave1 == ave2) {
            return 0;
        } else if(ave1 > ave2) {
            return -1;
        } else {
            return 1;
        }
    }
    
}
