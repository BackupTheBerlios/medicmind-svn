/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.MedicationFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Birger
 */
@Stateless
public class MedicationBean implements MedicationRemote {

    @EJB
    private MedicationFacadeLocal medFacade;

    public int create(String name) {
        if (name == null || name.equals(""))
            return 1;
        else {
            return medFacade.addMedication(name);
        }
    }
    
    
 
}
