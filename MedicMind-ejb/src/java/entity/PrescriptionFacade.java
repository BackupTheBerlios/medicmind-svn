/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Birger
 */
@Stateless
public class PrescriptionFacade implements PrescriptionFacadeLocal {

    @PersistenceContext
    private EntityManager em;

    public int addPrescription(int dosage, String unit, int frequency,
            Date startdate, Date enddate, String remarks, Users patient,
            Users gp, Medication medication) {
        Prescription prescription = new Prescription(dosage, unit, frequency,
            startdate, enddate, remarks, patient, gp, medication);
        create(prescription);
        return 0;
    }

     /**
     * Creates a new prescription in the database.
     *
     * @param Prescription prescription : the prescription that has to be added to
     * the database.
     */
    public void create(Prescription prescription) {
        em.persist(prescription);
    }

        /**
     * Edits an existing prescription in the database.
     *
     * @param Prescription prescription : the prescription that has to be edited in
     * the database.
     */
    public void edit(Prescription prescription) {
        em.merge(prescription);
    }

    /**
     * Removes an existing prescription from the database.
     *
     * @param Prescription prescription : the prescription that has to be removed from the database.
     */
    public void remove(Prescription prescription) {
        em.remove(em.merge(prescription));
    }

    /**
     * Finds a specific prescription by it's primary key (his ID).
     *
     * @param Object id : the primary key of the prescription we search.
     * @return Prescription : the required prescription.
     */
    public Prescription find(Object id) {
        return em.find(entity.Prescription.class, id);
    }


 
}
