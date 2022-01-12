package com.iquestgroup.remotelearning.week2.sample2;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Product> products = new ArrayList<Product>();
    products.add(new Phone());
    products.add(new Chocolate());

    printExpirationDateStatistics(products);
  }

  private static void printExpirationDateStatistics(List<Product> foodProducts) {
    for (Product product : foodProducts) {
      System.out.println(product.getExpirationDate());
    }
  }
}
