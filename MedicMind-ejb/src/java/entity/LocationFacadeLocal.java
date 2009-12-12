/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import javax.ejb.Local;

/**
 *
 * @author Birger
 */
@Local
public interface LocationFacadeLocal {

    int addLocation(String street, String number, String zipcode,
            String town, String Country, String phonenumber, String email,
            Users patient);
    
}
