/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author ginaj
 */
public class Not implements Criterion {

    private Criterion criteria;
    
    public Not(Criterion criteria) {
        this.criteria = criteria;
    }
    
    @Override
    public boolean complies(String line) {
        if(criteria.complies(line)) {
            return false;
        }
        return true;
    }
    
}
