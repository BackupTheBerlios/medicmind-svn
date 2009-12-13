/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.Medication;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Birger
 */
@Remote
public interface MedicationRemote {

    int create(String name);

    int update(String id, String name);

    int remove(String name);

    String getName(String id);

    public Medication getById(String id);

    public Medication getByName(String name);
            
    public List<Medication> getAll();
    
}
