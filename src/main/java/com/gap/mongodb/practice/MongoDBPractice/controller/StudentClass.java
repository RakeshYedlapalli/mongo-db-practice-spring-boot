package com.gap.mongodb.practice.MongoDBPractice.controller;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {

    String ss = "(.*) World";


    List<String> list = new ArrayList<>();


    private String name;
    private double salary;
    private int id;

    public String getName() {
        if (!list.isEmpty()) {
            extracted();

        }
        getStringByString("This is message");
        return name;
    }

    private void extracted() {
        System.out.println("Hello dl dlddf lsd ");
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void getStringByString(String message) {
        System.out.println("This is message");
        System.out.println("This is message");
        System.out.println("This is message");
    }


}
