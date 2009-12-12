/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Birger
 */
@Stateless
public class TaskFacade implements TaskFacadeLocal {

    @PersistenceContext
    private EntityManager em;

    public int create(int id, String description, Date timeplanned, Date timeok,
            Prescription prescription) {

        Task task = new Task(id, description, timeplanned, timeok, prescription);
        create(task);
        return 0;
    }
    
     /**
     * Creates a new task in the database.
     *
     * @param Task task : the task that has to be added to
     * the database.
     */
    public void create(Task task) {
        em.persist(task);
    }

        /**
     * Edits an existing task in the database.
     *
     * @param Task task : the task that has to be edited in
     * the database.
     */
    public void edit(Task task) {
        em.merge(task);
    }

    /**
     * Removes an existing task from the database.
     *
     * @param Task task : the task that has to be removed from the database.
     */
    public void remove(Task task) {
        em.remove(em.merge(task));
    }

    /**
     * Finds a specific task by it's primary key (his ID).
     *
     * @param Object id : the primary key of the task we search.
     * @return Task : the required task.
     */
    public Task find(Object id) {
        return em.find(entity.Task.class, id);
    }

 
}
