/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product_1.findAll", query = "SELECT p FROM Product_1 p")
    , @NamedQuery(name = "Product_1.findByProductId", query = "SELECT p FROM Product_1 p WHERE p.productId = :productId")
    , @NamedQuery(name = "Product_1.findByPurchaseCost", query = "SELECT p FROM Product_1 p WHERE p.purchaseCost = :purchaseCost")
    , @NamedQuery(name = "Product_1.findByQuantityOnHand", query = "SELECT p FROM Product_1 p WHERE p.quantityOnHand = :quantityOnHand")
    , @NamedQuery(name = "Product_1.findByMarkup", query = "SELECT p FROM Product_1 p WHERE p.markup = :markup")
    , @NamedQuery(name = "Product_1.findByAvailable", query = "SELECT p FROM Product_1 p WHERE p.available = :available")
    , @NamedQuery(name = "Product_1.findByDescription", query = "SELECT p FROM Product_1 p WHERE p.description = :description")})
public class Product_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PURCHASE_COST")
    private BigDecimal purchaseCost;
    @Column(name = "QUANTITY_ON_HAND")
    private Integer quantityOnHand;
    @Column(name = "MARKUP")
    private BigDecimal markup;
    @Column(name = "AVAILABLE")
    private String available;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<PurchaseOrder_1> purchaseOrderCollection;
    @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "MANUFACTURER_ID")
    @ManyToOne(optional = false)
    private Manufacturer_1 manufacturerId;
    @JoinColumn(name = "PRODUCT_CODE", referencedColumnName = "PROD_CODE")
    @ManyToOne(optional = false)
    private ProductCode productCode;

    public Product_1() {
    }

    public Product_1(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(BigDecimal purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public BigDecimal getMarkup() {
        return markup;
    }

    public void setMarkup(BigDecimal markup) {
        this.markup = markup;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<PurchaseOrder_1> getPurchaseOrderCollection() {
        return purchaseOrderCollection;
    }

    public void setPurchaseOrderCollection(Collection<PurchaseOrder_1> purchaseOrderCollection) {
        this.purchaseOrderCollection = purchaseOrderCollection;
    }

    public Manufacturer_1 getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Manufacturer_1 manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public void setProductCode(ProductCode productCode) {
        this.productCode = productCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product_1)) {
            return false;
        }
        Product_1 other = (Product_1) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Product_1[ productId=" + productId + " ]";
    }
    
}
