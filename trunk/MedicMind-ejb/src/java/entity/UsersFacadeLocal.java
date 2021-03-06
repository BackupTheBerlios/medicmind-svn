/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Birger
 */
@Local
public interface UsersFacadeLocal {

    int addPatient(String ssn, String username, String password, String firstname,
            String lastname, Date birthdate, String bloodgroup, Date lastconsult,
            Date nextconsult, Location location);

    public int addGp(String ssn, String username, String password,
        String firstname, String lastname);

    boolean isUser(String username, String password);

    boolean isGp(String username, String password);

    public List<Users> getPatients(String username, String password);

    boolean exists(String name);

    Users findBySsn(String ssn);
    
}
