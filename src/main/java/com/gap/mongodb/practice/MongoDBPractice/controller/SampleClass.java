package com.gap.mongodb.practice.MongoDBPractice.controller;

import com.gap.mongodb.practice.MongoDBPractice.model.ToDo;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleClass {
    public static void main(String[] args) {


        int arr[] = {1,2,3,4,4,5,6};
                System.out.println("this is array address=====>"+arr);
        ToDo t = new ToDo();
        t.setTodo("rakesh");
        List<ToDo> lstOfString = Arrays.asList(t);

        System.out.println(lstOfString.get(0).getTodo());


        lstOfString = lstOfString.stream().map(i->{
            i.setTodo("PROCESSING");
                    return i;
        }).collect(Collectors.toList());
        System.out.println(lstOfString.get(0).getTodo());
        BiFunction<ToDo,String,ToDo> bif = (o, s)->{
            o.setTodo("pro");
            return o;
        } ;
      //  bif.apply(new ToDo())
    }

}
