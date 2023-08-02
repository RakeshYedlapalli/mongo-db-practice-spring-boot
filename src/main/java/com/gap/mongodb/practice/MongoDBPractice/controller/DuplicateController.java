package com.gap.mongodb.practice.MongoDBPractice.controller;

import com.gap.mongodb.practice.MongoDBPractice.model.ToDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@Slf4j
//@RequestMapping("/thisIsDuplicate")
public class DuplicateController {

    @GetMapping("/getAllTodoss/{name}")
    public ResponseEntity<?> getAllTodos(@PathVariable("name") String name){
        log.info("this is get all todos: {}", name,new Exception("This is exception").getMessage());
        return new ResponseEntity("This is from duplicate controller", HttpStatus.OK);
    }
}
