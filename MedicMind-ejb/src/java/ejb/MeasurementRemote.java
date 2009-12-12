/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Remote;

/**
 *
 * @author Birger
 */
@Remote
public interface MeasurementRemote {

    int create(String type, int value, String patientSsn);
    
}
