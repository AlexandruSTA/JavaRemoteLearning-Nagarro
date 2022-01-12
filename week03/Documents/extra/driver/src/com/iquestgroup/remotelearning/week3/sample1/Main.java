package com.iquestgroup.remotelearning.week3.sample1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<TaxiDriver> drivers = new ArrayList<TaxiDriver>();
        drivers.add(new TaxiDriver("Vlad"));
        DispatchOperator operator = new DispatchOperator("Dan", drivers);

        operator.dispatch("Calea Motilor nr. 6");
    }
}
