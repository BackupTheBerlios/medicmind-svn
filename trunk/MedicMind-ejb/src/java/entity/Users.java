/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Birger
 */
@Entity
@Table(name = "USERS")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT p FROM Users p"),
    @NamedQuery(name = "Users.findBySsn", query = "SELECT p FROM Users p WHERE p.ssn = :ssn"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT p FROM Users p WHERE p.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT p FROM Users p WHERE p.password = :password"),
    @NamedQuery(name = "Users.findByFirstname", query = "SELECT p FROM Users p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Users.findByLastname", query = "SELECT p FROM Users p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Users.findByBirthdate", query = "SELECT p FROM Users p WHERE p.birthdate = :birthdate"),
    @NamedQuery(name = "Users.findByBloodgroup", query = "SELECT p FROM Users p WHERE p.bloodgroup = :bloodgroup"),
    @NamedQuery(name = "Users.findByLastconsult", query = "SELECT p FROM Users p WHERE p.lastconsult = :lastconsult"),
    @NamedQuery(name = "Users.findByNextconsult", query = "SELECT p FROM Users p WHERE p.nextconsult = :nextconsult")
})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SSN")
    private String ssn;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Column(name = "BLOODGROUP")
    private String bloodgroup;
    @Column(name = "LASTCONSULT")
    @Temporal(TemporalType.DATE)
    private Date lastconsult;
    @Column(name = "NEXTCONSULT")
    @Temporal(TemporalType.DATE)
    private Date nextconsult;
    @Column(name = "ROLENAME")
    private String rolename;
    @OneToOne
    private Location location;
    @ManyToOne
    private Users gp;
    @OneToMany(mappedBy = "patient")
    private List<Measurement> measurements;
    @OneToMany(mappedBy = "patient")
    private List<Prescription> prescriptions;


    public Users() {
    }

    public Users(String ssn) {
        this.ssn = ssn;
    }

    //Constructors for doctors
    public Users(String ssn, String username, String password, String firstname,
            String lastname) {
        this.ssn = ssn;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.rolename = "GP";
    }

    //Constructors for patients
    public Users(String ssn, String username, String password, String firstname,
            String lastname, Date birthdate, String bloodgroup, Date lastconsult,
            Date nextconsult) {
        this.ssn = ssn;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.bloodgroup = bloodgroup;
        this.lastconsult = lastconsult;
        this.nextconsult = nextconsult;
        this.rolename = "PATIENT";
    }

    public Users(String ssn, String username, String password, String firstname,
            String lastname, Date birthdate, String bloodgroup, Date lastconsult,
            Date nextconsult, Location location) {
        this.ssn = ssn;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.bloodgroup = bloodgroup;
        this.lastconsult = lastconsult;
        this.nextconsult = nextconsult;
        this.location = location;
        this.rolename = "PATIENT";
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public Date getLastconsult() {
        return lastconsult;
    }

    public void setLastconsult(Date lastconsult) {
        this.lastconsult = lastconsult;
    }

    public Date getNextconsult() {
        return nextconsult;
    }

    public void setNextconsult(Date nextconsult) {
        this.nextconsult = nextconsult;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location Location) {
        this.location = Location;
    }

    public Users getGp() {
        return gp;
    }

    public void setGp(Users gp) {
        this.gp = gp;
    }


    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Patient[ssn=" + ssn + "]";
    }

}
