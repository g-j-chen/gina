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
public class Both implements Criterion {

    private Criterion firstCriteria;
    private Criterion secondCriteria;
    
    public Both(Criterion firstCriteria, Criterion secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }
    
    @Override
    public boolean complies(String line) {
        return firstCriteria.complies(line) && secondCriteria.complies(line);
    }
    
}
