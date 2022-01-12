package com.nagarro.week2.extra.product;

public class ElectricalProduct extends Product implements IElectricalProductDetails {
    protected int warranty; // number of years

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }
}
