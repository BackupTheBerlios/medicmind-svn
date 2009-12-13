/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Birger
 */
@Local
public interface MedicationFacadeLocal {

    int addMedication(String name);

    int updateMedication(String id, String name);

    int removeMedication(String id);

    boolean exists(String name);

    String getName(String id);

    Medication findById(String id);

    Medication findByName(String name);

    List<Medication> findAll();
    
}
