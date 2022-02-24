package com.nagarro.service;

import com.nagarro.model.Day;
import com.nagarro.model.Month;

import java.util.Date;
import java.util.List;

public class DateFormatter {
    private final Date date;

    public DateFormatter(Date date) {
        this.date = date;
    }

    public void extractDate() {
        List<String> dateInformations = List.of(date.toString().split(" "));
        Day letterDay = extractDay(dateInformations.get(0));
        int numericDay = Integer.parseInt(dateInformations.get(2));
        Month month = extractMonth(dateInformations.get(1));
        int year = Integer.parseInt(dateInformations.get(dateInformations.size() - 1));
        formatDate(letterDay, numericDay, month, year);
    }

    public Day extractDay(String day) {
        Day extractedDay = null;
        switch (day) {
            case "Mon" -> extractedDay = Day.Monday;
            case "Tue" -> extractedDay = Day.Tuesday;
            case "Wed" -> extractedDay = Day.Wednesday;
            case "Thu" -> extractedDay = Day.Thursday;
            case "Fri" -> extractedDay = Day.Friday;
            case "Sat" -> extractedDay = Day.Saturday;
            case "Sun" -> extractedDay = Day.Sunday;
        }
        return extractedDay;
    }

    public Month extractMonth(String month) {
        Month extractedMonth = null;
        switch (month) {
            case "Jan" -> extractedMonth = Month.January;
            case "Feb" -> extractedMonth = Month.February;
            case "Mar" -> extractedMonth = Month.March;
            case "Apr" -> extractedMonth = Month.April;
            case "May" -> extractedMonth = Month.May;
            case "Jun" -> extractedMonth = Month.June;
            case "Jul" -> extractedMonth = Month.July;
            case "Aug" -> extractedMonth = Month.August;
            case "Sep" -> extractedMonth = Month.September;
            case "Oct" -> extractedMonth = Month.October;
            case "Nov" -> extractedMonth = Month.November;
            case "Dec" -> extractedMonth = Month.December;
        }
        return extractedMonth;
    }

    public void formatDate(Day letterDay, int numericDay, Month month, int year) {
        System.out.println(letterDay + "(" + numericDay + ") " + month + " " + year);
    }
}
