package com.gap.mongodb.practice.MongoDBPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Set;

@Component
public class ClassPathScanning {

    @Autowired
    RestTemplate restTemplate;


    public static void main(String[] args) {
      //  new ClassPathScanning().callAPI();
        System.out.println("Hello How are you..");
        String ss;
        try {
            //ss.isEmpty()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
