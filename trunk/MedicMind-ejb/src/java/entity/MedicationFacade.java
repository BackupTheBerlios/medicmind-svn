/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Birger
 */
@Stateless
public class MedicationFacade implements MedicationFacadeLocal {

    @PersistenceContext
    private EntityManager em;

    public int addMedication(String name) {
        Medication existing = findByName(name);
        if (existing != null) {
            return 3;
        } else {
            Medication medication = new Medication(name);
            create(medication);
            return 0;
        }
    }

    public int updateMedication(String id, String name) {
        Medication existing = findById(id);
        if (existing == null) {
            return 1;
        } else {
            existing.setName(name);
            edit(existing);
            return 0;
        }
    }

    public int removeMedication(String name) {
        Medication existing = findByName(name);
        if (existing == null) {
            return 1;
        } else {
            remove(existing);
            return 0;
        }
    }

    public String getName(String id){
        return findById(id).getName();
    }

    public boolean exists(String name) {
        return findByName(name) != null;
    }

     /**
     * Creates a new medication in the database.
     *
     * @param Medication medication : the medication that has to be added
     * to the database.
     */
    public void create(Medication medication) {
        em.persist(medication);
    }

     /**
     * Edits an existing medication in the database.
     *
     * @param Medication medication : the medication that has to be edited
     * in the database.
     */
    public void edit(Medication medication) {
        em.merge(medication);
    }

    /**
     * Removes an existing medication from the database.
     *
     * @param Medication medication : the medication that has to be removed
     * from the database.
     */
    public void remove(Medication medication) {
        em.remove(em.merge(medication));
    }

    /**
     * Finds a specific medication by it's primary key (his ID).
     *
     * @param Object id : the primary key of the medication we search.
     * @return Medication : the required medication.
     */
    public Medication find(Object id) {
        return em.find(entity.Medication.class, id);
    }

    public Medication findById(String id) {
        try {
            Medication medication = (Medication) em.createNamedQuery("Medication.findById").setParameter("id", id).getSingleResult();
            return medication;
        } catch (Exception e) {
            return null;
        }
    }

    public Medication findByName(String name) {
        try {
            Medication medication = (Medication) em.createNamedQuery("Medication.findByName").setParameter("name", name).getSingleResult();
            return medication;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Medication> findAll() {
        try {
            List<Medication> medications = (List<Medication>) em.createNamedQuery("Medication.findAll").getResultList();
            return medications;
        } catch (Exception e) {
            return null;
        }
    }
 
}
