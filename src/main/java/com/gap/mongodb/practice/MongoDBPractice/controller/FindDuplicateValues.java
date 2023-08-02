package com.gap.mongodb.practice.MongoDBPractice.controller;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateValues {
    public volatile boolean isValue = true;
    public static void main(String[] args) {
    System.out.print(findDuplicates(Arrays.asList(-1,1,3,2,2,2,5,6,-1,3,6),2));
    }

    public static List<Integer> findDuplicates(List<Integer> listContainingDuplicates,int numberOfDuplicates)
    {
       /* final Set<Integer> setToReturn = new HashSet<>();
        final Set<Integer> set1 = new HashSet<>();

        for (Integer yourInt : listContainingDuplicates)
        {
            if (!set1.add(yourInt))
            {
                setToReturn.add(yourInt);
            }
        }*/
        //List new ArrayList<>(setToReturn);

        Map<Integer,Long> duplicateList =  listContainingDuplicates.stream().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );
        List<Integer> listOfDuplicates = new ArrayList<>();
        for (Map.Entry<Integer,Long> entry : duplicateList.entrySet()) {
            if(entry.getValue()==numberOfDuplicates){
                listOfDuplicates.add(entry.getKey());
        }
    }

        return listOfDuplicates;
    }
}
