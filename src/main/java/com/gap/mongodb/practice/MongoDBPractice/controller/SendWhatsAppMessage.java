package com.gap.mongodb.practice.MongoDBPractice.controller;

import java.util.HashMap;

public class SendWhatsAppMessage {


    public static void main(String[] args) {
        HashMap<String, Integer> map
                = new HashMap<>();
        map.put("a", 100);
        map.put("b", 200);
        map.put("c", 300);
        map.put("d", 400);

        newMethod(map);
    }

    private static void newMethod(HashMap<String, Integer> map) {
        // print map details
        System.out.println("HashMap: "
                + map.toString());

        // provide key whose value has to be obtained
        // and default value for the key. Store the
        // return value in k
        int k = map.getOrDefault("bs", 500);
        System.out.println("K is => " + k);

        String thisIsExtractedString = "rakesh yedlapalli";
        String query = thisIsExtractedString;
    }
}
