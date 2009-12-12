 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Remote;

/**
 *
 * @author Birger
 */
@Remote
public interface GpRemote {

     /**
     * Creates a new gp
     *
     * @param ssn The ssn
     * @param password The password
     * @param username The username
     * @param firstname The firstname
     * @param lastname The lastname
     *
     * @return 0: succesful
     *         1: failed; invalid username
     *         2: failed; invalid password
     *         3: failed; username already exists
     */
    int create(String ssn, String username, String password,
            String firstname, String lastname);


    /**
     * Checks if this is a valid username/password combo.
     *
     * @param username The username
     * @param password The password
     *
     * @return 0: yes
     *         1: username does not exist
     *         2: invalid password
     */
    int authenticate(String username, String password);

    boolean isGp(String username, String password);
    
}
