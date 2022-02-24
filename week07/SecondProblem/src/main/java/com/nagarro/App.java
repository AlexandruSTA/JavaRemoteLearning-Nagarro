package com.nagarro;

import com.nagarro.service.DateFormatter;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        DateFormatter dateFormatter = new DateFormatter(new Date());
        System.out.println("================Formatted Date================");
        dateFormatter.extractDate();
    }
}
