package com.gap.mongodb.practice.MongoDBPractice.controller;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class VendorProfileLogic {
    public static void main(String[] args) {

        Set<String> setOfIds = getIds(100);
        final AtomicInteger counter = new AtomicInteger();
        final Collection<List<String>> result = setOfIds.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() /
                        10))
                .values();

        System.out.print(result);
    }

    public static  Set<String> getIds(int number){
        Set<String> setOfIds = new HashSet<>();
        for(int i=0;i<number;i++){
            setOfIds.add(getSomeRandomString());
        }
        return setOfIds;
    }

    public static String getSomeRandomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
