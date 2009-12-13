/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.Medication;
import entity.MedicationFacadeLocal;
import java.util.List;
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

    public int update(String id, String name) {
        return medFacade.updateMedication(id, name);
    }

    public int remove(String name) {
        return medFacade.removeMedication(name);
    }

    public String getName(String id){
        return medFacade.getName(id);
    }

    public Medication getById(String id){
        return medFacade.findById(id);
    }

    public Medication getByName(String name){
        return medFacade.findByName(name);
    }

    public List<Medication> getAll(){
        return medFacade.findAll();
    }   
    
 
}
