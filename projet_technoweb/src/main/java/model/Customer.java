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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer_1.findAll", query = "SELECT c FROM Customer_1 c")
    , @NamedQuery(name = "Customer_1.findByCustomerId", query = "SELECT c FROM Customer_1 c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "Customer_1.findByName", query = "SELECT c FROM Customer_1 c WHERE c.name = :name")
    , @NamedQuery(name = "Customer_1.findByAddressline1", query = "SELECT c FROM Customer_1 c WHERE c.addressline1 = :addressline1")
    , @NamedQuery(name = "Customer_1.findByAddressline2", query = "SELECT c FROM Customer_1 c WHERE c.addressline2 = :addressline2")
    , @NamedQuery(name = "Customer_1.findByCity", query = "SELECT c FROM Customer_1 c WHERE c.city = :city")
    , @NamedQuery(name = "Customer_1.findByState", query = "SELECT c FROM Customer_1 c WHERE c.state = :state")
    , @NamedQuery(name = "Customer_1.findByPhone", query = "SELECT c FROM Customer_1 c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customer_1.findByFax", query = "SELECT c FROM Customer_1 c WHERE c.fax = :fax")
    , @NamedQuery(name = "Customer_1.findByEmail", query = "SELECT c FROM Customer_1 c WHERE c.email = :email")
    , @NamedQuery(name = "Customer_1.findByCreditLimit", query = "SELECT c FROM Customer_1 c WHERE c.creditLimit = :creditLimit")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
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
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CREDIT_LIMIT")
    private Integer creditLimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<PurchaseOrder_1> purchaseOrderCollection;
    @JoinColumn(name = "DISCOUNT_CODE", referencedColumnName = "DISCOUNT_CODE")
    @ManyToOne(optional = false)
    private DiscountCode_1 discountCode;
    @JoinColumn(name = "ZIP", referencedColumnName = "ZIP_CODE")
    @ManyToOne(optional = false)
    private MicroMarket_1 zip;

    public Customer_1() {
    }

    public Customer_1(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    @XmlTransient
    public Collection<PurchaseOrder_1> getPurchaseOrderCollection() {
        return purchaseOrderCollection;
    }

    public void setPurchaseOrderCollection(Collection<PurchaseOrder_1> purchaseOrderCollection) {
        this.purchaseOrderCollection = purchaseOrderCollection;
    }

    public DiscountCode_1 getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode_1 discountCode) {
        this.discountCode = discountCode;
    }

    public MicroMarket_1 getZip() {
        return zip;
    }

    public void setZip(MicroMarket_1 zip) {
        this.zip = zip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer_1)) {
            return false;
        }
        Customer_1 other = (Customer_1) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Customer_1[ customerId=" + customerId + " ]";
    }
    
}
