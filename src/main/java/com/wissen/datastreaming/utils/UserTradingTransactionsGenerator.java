package com.wissen.datastreaming.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserTradingTransactionsGenerator {
	
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static final List<String> users =
            Arrays.asList(
                    "Ravi","Lokendra", "Priya", "Harsh", "Pradeep","Atul","Sanjeev");


    private static final List<String> securities =
            Arrays.asList(
                    "hdfc",
                    "icici",
                    "kotak mahindra",
                    "reliance",
                    "airtel",
                    "tata","wipro");
    
    private static final List<Integer> currentPosition =
            Arrays.asList(
                   100,
                   85,
                   250,
                   180,
                   50,
                    125,92);


    public static String randomUsers() {
        return users.get(RANDOM.nextInt(users.size()));
    }

    public static String randomScurites() {
        return securities.get(RANDOM.nextInt(securities.size()));
    }
    
    public static Integer randomCurrentPosition() {
        return currentPosition.get(RANDOM.nextInt(currentPosition.size()));
    }

}
