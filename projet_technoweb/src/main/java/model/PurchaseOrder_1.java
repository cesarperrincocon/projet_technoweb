/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cperrinc
 */
@Entity
@Table(name = "PURCHASE_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrder_1.findAll", query = "SELECT p FROM PurchaseOrder_1 p")
    , @NamedQuery(name = "PurchaseOrder_1.findByOrderNum", query = "SELECT p FROM PurchaseOrder_1 p WHERE p.orderNum = :orderNum")
    , @NamedQuery(name = "PurchaseOrder_1.findByQuantity", query = "SELECT p FROM PurchaseOrder_1 p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "PurchaseOrder_1.findByShippingCost", query = "SELECT p FROM PurchaseOrder_1 p WHERE p.shippingCost = :shippingCost")
    , @NamedQuery(name = "PurchaseOrder_1.findBySalesDate", query = "SELECT p FROM PurchaseOrder_1 p WHERE p.salesDate = :salesDate")
    , @NamedQuery(name = "PurchaseOrder_1.findByShippingDate", query = "SELECT p FROM PurchaseOrder_1 p WHERE p.shippingDate = :shippingDate")
    , @NamedQuery(name = "PurchaseOrder_1.findByFreightCompany", query = "SELECT p FROM PurchaseOrder_1 p WHERE p.freightCompany = :freightCompany")})
public class PurchaseOrder_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDER_NUM")
    private Integer orderNum;
    @Column(name = "QUANTITY")
    private Short quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SHIPPING_COST")
    private BigDecimal shippingCost;
    @Column(name = "SALES_DATE")
    @Temporal(TemporalType.DATE)
    private Date salesDate;
    @Column(name = "SHIPPING_DATE")
    @Temporal(TemporalType.DATE)
    private Date shippingDate;
    @Column(name = "FREIGHT_COMPANY")
    private String freightCompany;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Customer_1 customerId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    @ManyToOne(optional = false)
    private Product_1 productId;

    public PurchaseOrder_1() {
    }

    public PurchaseOrder_1(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getFreightCompany() {
        return freightCompany;
    }

    public void setFreightCompany(String freightCompany) {
        this.freightCompany = freightCompany;
    }

    public Customer_1 getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer_1 customerId) {
        this.customerId = customerId;
    }

    public Product_1 getProductId() {
        return productId;
    }

    public void setProductId(Product_1 productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderNum != null ? orderNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrder_1)) {
            return false;
        }
        PurchaseOrder_1 other = (PurchaseOrder_1) object;
        if ((this.orderNum == null && other.orderNum != null) || (this.orderNum != null && !this.orderNum.equals(other.orderNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PurchaseOrder_1[ orderNum=" + orderNum + " ]";
    }
    
}
