/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Birger
 */
@Stateless
public class MeasurementFacade implements MeasurementFacadeLocal {


    @PersistenceContext
    private EntityManager em;

    public int addMeasurement(String type, int val,Users patient) {
        Measurement msm = new Measurement(type, val, patient);
        create(msm);
        return 0;
    }
    
     /**
     * Creates a new measurement in the database.
     *
     * @param Measurement measurement : the measurement that has to be added to
     * the database.
     */
    public void create(Measurement measurement) {
        em.persist(measurement);
    }

        /**
     * Edits an existing measurement in the database.
     *
     * @param Measurement measurement : the measurement that has to be edited in
     * the database.
     */
    public void edit(Measurement measurement) {
        em.merge(measurement);
    }

    /**
     * Removes an existing measurement from the database.
     *
     * @param Account account : the account that has to be removed from the database.
     */
    public void remove(Measurement measurement) {
        em.remove(em.merge(measurement));
    }

    /**
     * Finds a specific measurement by it's primary key (his ID).
     *
     * @param Object id : the primary key of the measurement we search.
     * @return Measurement : the required measurement.
     */
    public Measurement find(Object id) {
        return em.find(entity.Measurement.class, id);
    }
 
}
