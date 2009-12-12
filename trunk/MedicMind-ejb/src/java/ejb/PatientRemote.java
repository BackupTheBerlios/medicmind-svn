/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Birger
 */
@Remote
public interface PatientRemote {

    int create(String ssn, String username, String password, String firstname,
            String lastname, Date birthdate, String bloodgroup, Date lastconsult,
            Date nextconsult, String street, String number, String zipcode,
            String town, String country, String phonenumber, String email);
    
}
