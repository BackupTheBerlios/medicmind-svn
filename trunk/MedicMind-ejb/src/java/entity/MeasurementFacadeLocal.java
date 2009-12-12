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
public interface MeasurementFacadeLocal {

    int addMeasurement(String type, int val,Users patient);
    
}
