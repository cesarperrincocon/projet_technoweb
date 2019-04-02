/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author cperrinc
 */
public class PurchaseOrder {

    private int ORDER_NUM;
    private int CUSTOMER_ID;
    private int PRODUCT_ID;
    private int QUANTITY;
    private double SHIPPING_COST;
    private Date SALES_DATE;
    private Date SHIPPING_DATE;
    private String FREIGHT_COMPANY;
    private String DESCRIPTION;

    public PurchaseOrder(int ORDER_NUM, int CUSTOMER_ID, int QUANTITY) {
        this.ORDER_NUM = ORDER_NUM;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.QUANTITY = QUANTITY;
    }

    public int getORDER_NUM() {
        return ORDER_NUM;
    }

    public void setORDER_NUM(int ORDER_NUM) {
        this.ORDER_NUM = ORDER_NUM;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public double getSHIPPING_COST() {
        return SHIPPING_COST;
    }

    public void setSHIPPING_COST(double SHIPPING_COST) {
        this.SHIPPING_COST = SHIPPING_COST;
    }

    public String getFREIGHT_COMPANY() {
        return FREIGHT_COMPANY;
    }

    public void setFREIGHT_COMPANY(String FREIGHT_COMPANY) {
        this.FREIGHT_COMPANY = FREIGHT_COMPANY;
    }

    public void setSHIPPING_DATE(Date SHIPPING_DATE) {
        this.SHIPPING_DATE = SHIPPING_DATE;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

}
