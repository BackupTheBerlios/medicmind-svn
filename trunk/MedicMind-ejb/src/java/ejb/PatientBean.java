/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.LocationFacadeLocal;
import entity.Location;
import entity.Users;
import entity.UsersFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Birger
 */
@Stateless
public class PatientBean implements PatientRemote {


    @EJB
    private LocationFacadeLocal locationFacade;
    @EJB
    private UsersFacadeLocal patientFacade;

    public int create(String ssn, String username, String password, String firstname, 
            String lastname, Date birthdate, String bloodgroup, Date lastconsult,
            Date nextconsult, String street, String number, String zipcode, String town,
            String country, String phonenumber, String email) {

        Users patient = new Users(ssn, username, password, firstname, lastname,
                birthdate, bloodgroup, lastconsult, nextconsult);
        Location location = new Location(street, number, zipcode, town, country,
                phonenumber, email, patient);
        return (patientFacade.addPatient(ssn, username, password, firstname,
                lastname, birthdate, bloodgroup, lastconsult, nextconsult,
                location) +
                locationFacade.addLocation(street, number, zipcode, town, country,
                phonenumber, email, patient));

    }
 
}
