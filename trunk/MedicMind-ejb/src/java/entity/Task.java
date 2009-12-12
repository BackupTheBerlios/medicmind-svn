/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Birger
 */
@Entity
@Table(name = "TASK")
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
    @NamedQuery(name = "Task.findById", query = "SELECT t FROM Task t WHERE t.id = :id"),
    @NamedQuery(name = "Task.findByDescription", query = "SELECT t FROM Task t WHERE t.description = :description"),
    @NamedQuery(name = "Task.findByTimeplanned", query = "SELECT t FROM Task t WHERE t.timeplanned = :timeplanned"),
    @NamedQuery(name = "Task.findByTimeok", query = "SELECT t FROM Task t WHERE t.timeok = :timeok")
})
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TIMEPLANNED")
    @Temporal(TemporalType.DATE)
    private Date timeplanned;
    @Column(name = "TIMEOK")
    @Temporal(TemporalType.DATE)
    private Date timeok;
    @ManyToOne
    private Prescription prescription;

    public Task() {
    }

    public Task(int id, String description, Date timeplanned, Date timeok, Prescription prescription) {
        this.id = id;
        this.description = description;
        this.timeplanned = timeplanned;
        this.timeok = timeok;
        this.prescription = prescription;
    }

    public Task(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimeplanned() {
        return timeplanned;
    }

    public void setTimeplanned(Date timeplanned) {
        this.timeplanned = timeplanned;
    }

    public Date getTimeok() {
        return timeok;
    }

    public void setTimeok(Date timeok) {
        this.timeok = timeok;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Task[id=" + id + "]";
    }

}
