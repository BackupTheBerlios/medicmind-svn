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
public class LocationFacade implements LocationFacadeLocal {

    @PersistenceContext
    private EntityManager em;

    public int addLocation(String street, String number, String zipcode,
            String town, String Country, String phonenumber, String email,
            Users patient) {
            Location loc = new Location(street, number, zipcode, town, Country,
                    phonenumber, email, patient);
            create(loc);
            return 0;
    }

     /**
     * Creates a new location in the database.
     *
     * @param Location location : the location that has to be added to the
     * database.
     */
    public void create(Location location) {
        em.persist(location);
    }

        /**
     * Edits an existing location in the database.
     *
     * @param Location location : the location that has to be edited in the database.
     */
    public void edit(Location location) {
        em.merge(location);
    }

    /**
     * Removes an existing location from the database.
     *
     * @param Location location : the location that has to be removed from the database.
     */
    public void remove(Location location) {
        em.remove(em.merge(location));
    }

    /**
     * Finds a specific gp by it's primary key (his id).
     *
     * @param Object id : the primary key of the location we search.
     * @return Location : the required location.
     */
    public Location find(Object id) {
        return em.find(entity.Location.class, id);
    }
    
 
}
