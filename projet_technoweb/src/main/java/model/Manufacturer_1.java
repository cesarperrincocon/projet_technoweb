/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cperrinc
 */
@Entity
@Table(name = "MANUFACTURER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manufacturer_1.findAll", query = "SELECT m FROM Manufacturer_1 m")
    , @NamedQuery(name = "Manufacturer_1.findByManufacturerId", query = "SELECT m FROM Manufacturer_1 m WHERE m.manufacturerId = :manufacturerId")
    , @NamedQuery(name = "Manufacturer_1.findByName", query = "SELECT m FROM Manufacturer_1 m WHERE m.name = :name")
    , @NamedQuery(name = "Manufacturer_1.findByAddressline1", query = "SELECT m FROM Manufacturer_1 m WHERE m.addressline1 = :addressline1")
    , @NamedQuery(name = "Manufacturer_1.findByAddressline2", query = "SELECT m FROM Manufacturer_1 m WHERE m.addressline2 = :addressline2")
    , @NamedQuery(name = "Manufacturer_1.findByCity", query = "SELECT m FROM Manufacturer_1 m WHERE m.city = :city")
    , @NamedQuery(name = "Manufacturer_1.findByState", query = "SELECT m FROM Manufacturer_1 m WHERE m.state = :state")
    , @NamedQuery(name = "Manufacturer_1.findByZip", query = "SELECT m FROM Manufacturer_1 m WHERE m.zip = :zip")
    , @NamedQuery(name = "Manufacturer_1.findByPhone", query = "SELECT m FROM Manufacturer_1 m WHERE m.phone = :phone")
    , @NamedQuery(name = "Manufacturer_1.findByFax", query = "SELECT m FROM Manufacturer_1 m WHERE m.fax = :fax")
    , @NamedQuery(name = "Manufacturer_1.findByEmail", query = "SELECT m FROM Manufacturer_1 m WHERE m.email = :email")
    , @NamedQuery(name = "Manufacturer_1.findByRep", query = "SELECT m FROM Manufacturer_1 m WHERE m.rep = :rep")})
public class Manufacturer_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MANUFACTURER_ID")
    private Integer manufacturerId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIP")
    private String zip;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "REP")
    private String rep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturerId")
    private Collection<Product_1> productCollection;

    public Manufacturer_1() {
    }

    public Manufacturer_1(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    @XmlTransient
    public Collection<Product_1> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product_1> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manufacturerId != null ? manufacturerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manufacturer_1)) {
            return false;
        }
        Manufacturer_1 other = (Manufacturer_1) object;
        if ((this.manufacturerId == null && other.manufacturerId != null) || (this.manufacturerId != null && !this.manufacturerId.equals(other.manufacturerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Manufacturer_1[ manufacturerId=" + manufacturerId + " ]";
    }
    
}
