/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Birger
 */
@Entity
@Table(name = "LOCATION")
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findById", query = "SELECT l FROM Location l WHERE l.id = :id"),
    @NamedQuery(name = "Location.findByStreet", query = "SELECT l FROM Location l WHERE l.street = :street"),
    @NamedQuery(name = "Location.findByNumber", query = "SELECT l FROM Location l WHERE l.number = :number"),
    @NamedQuery(name = "Location.findByZipcode", query = "SELECT l FROM Location l WHERE l.zipcode = :zipcode"),
    @NamedQuery(name = "Location.findByTown", query = "SELECT l FROM Location l WHERE l.town = :town"),
    @NamedQuery(name = "Location.findByCountry", query = "SELECT l FROM Location l WHERE l.country = :country"),
    @NamedQuery(name = "Location.findByPhonenumber", query = "SELECT l FROM Location l WHERE l.phonenumber = :phonenumber"),
    @NamedQuery(name = "Location.findByEmail", query = "SELECT l FROM Location l WHERE l.email = :email")
})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "STREET")
    private String street;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Column(name = "TOWN")
    private String town;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Column(name = "EMAIL")
    private String email;
        @OneToOne(mappedBy = "location")
    private Users patient;

    public Location() {
    }

    public Location(String street, String number, String zipcode, String town,
            String country, String phonenumber, String email, Users patient) {
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.town = town;
        this.country = country;
        this.phonenumber = phonenumber;
        this.email = email;
        this.patient = patient;
    }

    public Location(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users getPatient() {
        return patient;
    }

    public void setPatient(Users patient) {
        this.patient = patient;
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Location[id=" + id + "]";
    }

}
