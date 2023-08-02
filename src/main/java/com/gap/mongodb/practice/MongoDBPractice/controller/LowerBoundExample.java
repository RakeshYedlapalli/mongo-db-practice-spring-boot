package com.gap.mongodb.practice.MongoDBPractice.controller;


import java.util.Arrays;
import java.util.List;

public class LowerBoundExample {

    public static void main(String[] args) {
        List<Integer> listOfints = Arrays.asList(2,3,4,45,5);
        List<Number> list = Arrays.asList(3.3,43.3,44.3);


        System.out.print(listOfints.contains(3));
        new LowerBoundExample().getLowerBound(listOfints);
    }



    public void getLowerBound(List<? extends Integer> listOfLower){
        System.out.println("This is lower bound list of integer=>"+listOfLower);
    }
}
