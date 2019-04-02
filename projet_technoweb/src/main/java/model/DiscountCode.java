package model;

/**
 * enregistrement de la table DISCOUNT_CODE
 * @author cperrinc
 */
public class DiscountCode {

    private String discountCode;

    private float rate;

    public DiscountCode(String discountCode, float rate) {
        this.discountCode = discountCode;
        this.rate = rate;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public float getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return this.discountCode;
    }

}
