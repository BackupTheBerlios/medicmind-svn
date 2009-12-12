/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Birger
 */
@Entity
@Table(name = "PRESCRIPTION")
@NamedQueries({
    @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p"),
    @NamedQuery(name = "Prescription.findById", query = "SELECT p FROM Prescription p WHERE p.id = :id"),
    @NamedQuery(name = "Prescription.findByDosage", query = "SELECT p FROM Prescription p WHERE p.dosage = :dosage"),
    @NamedQuery(name = "Prescription.findByUnit", query = "SELECT p FROM Prescription p WHERE p.unit = :unit"),
    @NamedQuery(name = "Prescription.findByFrequency", query = "SELECT p FROM Prescription p WHERE p.frequency = :frequency"),
    @NamedQuery(name = "Prescription.findByStartdate", query = "SELECT p FROM Prescription p WHERE p.startdate = :startdate"),
    @NamedQuery(name = "Prescription.findByEnddate", query = "SELECT p FROM Prescription p WHERE p.enddate = :enddate"),
    @NamedQuery(name = "Prescription.findByRemarks", query = "SELECT p FROM Prescription p WHERE p.remarks = :remarks")
})
public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DOSAGE")
    private Integer dosage;
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "FREQUENCY")
    private Integer frequency;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column(name = "REMARKS")
    private String remarks;
    @ManyToOne
    private Users Gp;
    @ManyToOne
    private Users patient;
    @OneToMany(mappedBy = "prescription")
    private List<Task> tasks;
    @ManyToOne
    private Medication medication;


    public Prescription() {
    }

    public Prescription(int dosage, String unit, int frequency, Date startdate,
            Date enddate, String remarks, Users patient, Users gp, Medication medication) {
        this.dosage = dosage;
        this.unit = unit;
        this.frequency = frequency;
        this.startdate = startdate;
        this.enddate = enddate;
        this.remarks = remarks;
        this.patient = patient;
        this.Gp = gp;
        this.medication = medication;
    }

    public Prescription(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Users getGp() {
        return Gp;
    }

    public void setGp(Users Gp) {
        this.Gp = Gp;
    }

    public Users getPatient() {
        return patient;
    }

    public void setPatient(Users patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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
        if (!(object instanceof Prescription)) {
            return false;
        }
        Prescription other = (Prescription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prescription[id=" + id + "]";
    }

}
