package com.iquestgroup.remotelearning.week2.sample2;

import java.util.Date;

/**
 * Product base class
 */
public class Product {

  protected String name;
  protected Date expirationDate;
  protected int warranty; // number of years
  protected int noCalories;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  public int getWarranty() {
    return warranty;
  }

  public void setWarranty(int warranty) {
    this.warranty = warranty;
  }

  public int getNoCalories() {
    return noCalories;
  }

  public void setNoCalories(int noCalories) {
    this.noCalories = noCalories;
  }

}
