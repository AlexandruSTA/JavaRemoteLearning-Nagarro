package com.nagarro.week2.extra.product;

import java.util.Date;

public class FoodProduct extends Product implements IFoodProductDetails {
    protected Date expirationDate;
    protected int noCalories;

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getNoCalories() {
        return noCalories;
    }

    public void setNoCalories(int noCalories) {
        this.noCalories = noCalories;
    }
}
