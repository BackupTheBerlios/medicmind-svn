/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Birger
 */
@Stateless
public class UsersFacade implements UsersFacadeLocal {

    @PersistenceContext
    private EntityManager em;

    public int addPatient(String ssn, String username, String password,
            String firstname, String lastname, Date birthdate, String bloodgroup,
            Date lastconsult, Date nextconsult, Location location) {
        Users existing = findBySsn(ssn);
        if (existing != null) {
            return 3;
        } else {
            Users patient = new Users(ssn, username, password, firstname,
                    lastname, birthdate, bloodgroup, lastconsult, nextconsult,
                    location);
            create(patient);
            return 0;
        }
    }

    public int addGp(String ssn, String username, String password,
        String firstname, String lastname) {
        Users existing = findByUsername(username);
        if (existing != null) {
            return 3;
        } else {
            Users gp = new Users(ssn, username, password,
            firstname, lastname);
            create(gp);
            return 0;
        }
    }

    public boolean isGp(String username, String password) {
        //Locates the gp (if any) with this unique username.
        Users gp = findByUsername(username);
        boolean valid = false;

        //If a gp with such an username exists and the password corresponds,
        //than the password is valid.
        if (gp != null) {
            if (password.equals(gp.getPassword()) && gp.getRolename().equals("GP")) {
                valid = true;
            }
        }
        return valid;
    }

    public boolean exists(String ssn) {
        return findBySsn(ssn) != null;
    }

    /**
     * Creates a new patient in the database.
     *
     * @param Users patient : the patient that has to be added
     * to the database.
     */
    public void create(Users patient) {
        em.persist(patient);
    }

     /**
     * Edits an existing patient in the database.
     *
     * @param Users patient : the patient that has to be edited
     * in the database.
     */
    public void edit(Users patient) {
        em.merge(patient);
    }

    /**
     * Removes an existing patient from the database.
     *
     * @param Users patient : the Users that has to be removed
     * from the database.
     */
    public void remove(Users patient) {
        em.remove(em.merge(patient));
    }

    /**
     * Finds a specific patient by it's primary key (his SSN).
     *
     * @param Object ssn : the primary key of the patient we search.
     * @return Users : the required patient.
     */
    public Users find(Object ssn) {
        return em.find(entity.Users.class, ssn);
    }

    public Users findBySsn(String ssn) {
        try {
            Users patient = (Users) em.createNamedQuery("User.findBySsn").setParameter("ssn", ssn).getSingleResult();
            return patient;
        } catch (Exception e) {
            return null;
        }
    }

    public Users findByUsername(String username) {
        try {
            Users gp = (Users) em.createNamedQuery("User.findByUsername").setParameter("username", username).getSingleResult();
            return gp;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Users> getPatients() {
        try{
            return getPatients();
        }catch (Exception e) {
            return null;
        }
    }


}
