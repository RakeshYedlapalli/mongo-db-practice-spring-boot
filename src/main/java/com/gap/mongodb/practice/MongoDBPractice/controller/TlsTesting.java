package com.gap.mongodb.practice.MongoDBPractice.controller;

import com.gap.mongodb.practice.MongoDBPractice.model.SeasonCodeMapping;
import com.gap.mongodb.practice.MongoDBPractice.repository.SeasonCodeResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/testConnection")
public class TlsTesting {

    @Autowired
    SeasonCodeResourceRepository seasonCodeResourceRepository;

    @GetMapping("/getByID")
    public ResponseEntity<SeasonCodeMapping> getSeasonByID(@RequestParam("id") String id){
        List<SeasonCodeMapping> optional =
                seasonCodeResourceRepository.findAll();

        return new ResponseEntity(optional, HttpStatus.OK);

    }




}
