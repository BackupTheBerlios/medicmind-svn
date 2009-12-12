/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Birger
 */
@Local
public interface TaskFacadeLocal {

    int create(int id, String description, Date timeplanned, Date timeok,
            Prescription prescription);
    
}
