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
public interface MedicationFacadeLocal {

    int addMedication(String name);

    boolean exists(String name);

    Medication findById(String id);
    
}
