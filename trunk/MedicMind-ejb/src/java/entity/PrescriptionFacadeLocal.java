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
public interface PrescriptionFacadeLocal {

    int addPrescription(int dosage, String unit, int frequency, Date startdate,
            Date enddate, String remarks, Users patient, Users gp, Medication medication);
    
}
