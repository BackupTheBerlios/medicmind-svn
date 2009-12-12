/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.MeasurementFacadeLocal;
import entity.Users;
import entity.UsersFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Birger
 */
@Stateless
public class MeasurementBean implements MeasurementRemote {

    @EJB
    private MeasurementFacadeLocal msmFacade;
    @EJB
    private UsersFacadeLocal pFacade;

    public int create(String type, int value, String patientSsn) {
        Users patient = pFacade.findBySsn(patientSsn);
        if (type == null || type.equals(""))
            return 1;
        else if (patient == null)
            return 2;
        else {
            return msmFacade.addMeasurement(type, value, patient);
        }
    }
    
    
 
}
