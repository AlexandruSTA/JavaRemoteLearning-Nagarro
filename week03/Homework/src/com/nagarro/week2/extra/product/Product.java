package com.nagarro.week2.extra.product;

/**
 * Product base class
 */
public abstract class Product implements IProductName {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
