package com.nagarro.week2.extra.product;

import java.util.Date;

public interface IFoodProductDetails {
    Date getExpirationDate();

    void setExpirationDate(Date expirationDate);

    int getNoCalories();

    void setNoCalories(int noCalories);
}
