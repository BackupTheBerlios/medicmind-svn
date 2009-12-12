/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.UsersFacadeLocal;
import java.util.List;
import java.util.ListIterator;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import 

/**
 *
 * @author Birger
 */
@Stateless
public class GpBean implements GpRemote {

    @EJB
    private UsersFacadeLocal gpFacade;

    public int create(String ssn, String username, String password,
            String firstname, String lastname) {
        if (username == null || username.equals(""))
            return 1;
        else if (password == null || password.equals(""))
            return 2;
        else {
            return gpFacade.addGp(ssn, username, password,
                firstname, lastname);
        }
    }

    public int authenticate(String username, String password) {
        if (gpFacade.exists(username)) {
            return (gpFacade.isGp(username, password)) ? 0 : 2;
        } else
            return 1;
    }

    public List<PatientRemote> getPatients() {
        List<Users> patients =  gpFacade.getPatients();
        ListIterator it = patients.listIterator();
        List<PatientRemote> p = null;
        return gpFacade.getPatients();
    }
    
}
