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
public interface PrescriptionRemote {

    int create(int dosage, String unit, int frequency,
            Date startdate, Date enddate, String remarks, String patientSsn,
            String gpSsn, String medicationId);
    
}
