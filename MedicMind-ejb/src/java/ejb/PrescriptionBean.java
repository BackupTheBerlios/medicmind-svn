/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.Medication;
import entity.MedicationFacadeLocal;
import entity.Users;
import entity.UsersFacadeLocal;
import entity.PrescriptionFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Birger
 */
@Stateless
public class PrescriptionBean implements PrescriptionRemote {

    @EJB
    private PrescriptionFacadeLocal prescriptionFacade;
    @EJB
    private UsersFacadeLocal userFacade;
    @EJB
    private MedicationFacadeLocal medicationFacade;

    public int create(int dosage, String unit, int frequency, Date startdate,
            Date enddate, String remarks, String patientSsn, String gpSsn,
            String medicationId) {

        Users patient = userFacade.findBySsn(patientSsn);
        Users gp = userFacade.findBySsn(gpSsn);
        Medication medication = medicationFacade.findById(medicationId);
        //TODO
        //Generate tasks
        return prescriptionFacade.addPrescription(dosage, unit, frequency, 
                startdate, enddate, remarks, patient, gp, medication);
    }
 
}
