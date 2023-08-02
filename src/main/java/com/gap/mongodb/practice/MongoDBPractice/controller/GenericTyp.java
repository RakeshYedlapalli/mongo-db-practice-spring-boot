package com.gap.mongodb.practice.MongoDBPractice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class GenericTyp {



    public static void main(String[] args) {


        List<Integer> listOfIntegers = Arrays.asList(1,3,4,4,5,6);
        new GenericTyp().upperBoundExample(listOfIntegers);


        List<Double> listOfDoubleNums = Arrays.asList(3.4,54.3,3.3,22.2);
        new GenericTyp().upperBoundExample(listOfDoubleNums);


        List<String> listOfStrings = Arrays.asList("This so","ddfsd");


    }

    public void upperBoundExample(List<? extends  Number> listOfSomething){

        String aThis = "This";

        String regex = "(.*) World";

   StudentClass studentClass = new StudentClass();

        String s = " is something==>";
        System.out.println(aThis + s + listOfSomething);


        String Hellow = "Hi";
        System.out.print(Hellow);
        System.out.print(Hellow);
        System.out.print(Hellow);
        System.out.print(Hellow);
        System.out.print(Hellow);
        System.out.print(Hellow);



    }


}
