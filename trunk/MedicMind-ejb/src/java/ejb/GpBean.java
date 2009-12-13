/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.Users;
import entity.UsersFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Birger
 */
@Stateless
public class GpBean implements GpRemote {

    @EJB
    private UsersFacadeLocal usersFacade;

    public int create(String ssn, String username, String password,
            String firstname, String lastname) {
        if (username == null || username.equals(""))
            return 1;
        else if (password == null || password.equals(""))
            return 2;
        else {
            return usersFacade.addGp(ssn, username, password,
                firstname, lastname);
        }
    }

    public int authenticate(String username, String password) {
   
        if (usersFacade.exists(username)) {
            return (usersFacade.isUser(username, password)) ? 0 : 2;
        } else
            return 1;
    
    }

    public boolean isGp(String username, String password) {
        return (usersFacade.isGp(username, password));
    }

    public List<Users> getPatients(String username, String password) {
        return usersFacade.getPatients(username, password);
    }
    
}
