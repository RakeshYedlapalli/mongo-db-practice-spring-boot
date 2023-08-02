package com.gap.mongodb.practice.MongoDBPractice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gap.mongodb.practice.MongoDBPractice.bean.TicketPriceResponse;
import com.gap.mongodb.practice.MongoDBPractice.model.ToDo;
import com.gap.mongodb.practice.MongoDBPractice.repository.TodoRepository;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@Component
public class TodoController {

    @Autowired
    TodoRepository todoRepository;
    private ExampleInterface ex;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RetryService retryService;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Value("${spring.data.mongodb.uri}")
    String dbName;
    //@Value("${spring.cloud.config.server.git.uri}") String configData;


    @GetMapping("/getAllTodos")
    public ResponseEntity<?> getAllTodos() {
       // callAPI();

        //retryService.checkStatus("");


        log.info("this is get all todos");
        System.out.print("This is db name =>" + dbName);

        // System.out.println("This is config file data=>"+configData);
        List<ToDo> listOfTods = todoRepository.findAll();
        if (!listOfTods.isEmpty()) {
            return new ResponseEntity<>(listOfTods, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Content available in db.", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getByTodoName/{name}")
    public ResponseEntity<?> getByToDoName(@PathVariable("name") String name) {
        List<ToDo> listOfTods = todoRepository.findByTodo(name);
        if (!listOfTods.isEmpty()) {
            return new ResponseEntity<>(listOfTods, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Content available in db.", HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/createToDos")
    //@Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    public ResponseEntity<?> createToDos(@RequestBody ToDo toDo,@RequestParam("isT") boolean isT) {
        toDo.setCredateAt(new Date(System.currentTimeMillis()));
        toDo.setUpdateAt(new Date(System.currentTimeMillis()));
        toDo.setTodo("This is default TO DO.");
        ToDo todo = null;
        try {
            todo = todoRepository.save(toDo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isT){
            throw new Exception("Exception Occured");
        }
        if (todo != null) {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Data couldn't be persisted in db...", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*@PostMapping("/sendList")
    public ResponseEntity<?> checkList(@RequestBody List<String> listOfStringOjbects){
       System.out.println(listOfStringOjbects);
       return null;
    }*/
    @GetMapping("/getToDoByid/{id}")
    public ResponseEntity<?> getToDoById(@PathVariable("id") String id) {

        Query query = new Query();
        query.addCriteria(
                new Criteria().and("description").regex("^.{3}" + "000202020020" + "(.*)$")
        );

        List<ToDo> result = mongoTemplate.find(query, ToDo.class);
        System.out.println("query - " + query.toString());

        for (ToDo foo : result) {
            System.out.println("result - " + foo);
        }



        Optional<ToDo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            return new ResponseEntity<>(todo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Records found with given id", HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/updateData")
    public ResponseEntity<?> updateTodoById(@RequestBody ToDo toDo) {
        toDo.setUpdateAt(new Date(System.currentTimeMillis()));
        ToDo toDo1 = todoRepository.save(toDo);
        if (toDo1 != null) {
            return new ResponseEntity<>(toDo1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Data couldn't be updated", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity deleteTodoById(@PathVariable("id") String id) {
        try {
            todoRepository.deleteById(id);
            return new ResponseEntity<>("The data is deleted successfully...", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Todo can't be deleted Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getListOfTodoByCondition/{todo}")
    public ResponseEntity findByCondition(@PathVariable("todo") String todo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("todo").is(todo));
        List<ToDo> toDoList = mongoTemplate.find(query, ToDo.class);
        if (!toDoList.isEmpty()) {
            return new ResponseEntity<>(toDoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Records found with given id", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/ticket-prices")
    public ResponseEntity getTicketPrice(@RequestParam("brandCode") String brandCode
            ,@RequestParam("assortedCustomerChoiceId") String assortedCustomerChoiceId) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        TicketPriceResponse ticketPriceResponse
                = objectMapper.readValue
                (new File("/Users/yadlapallirakesh/Documents/SpringBootPracticeworkspace/MongoDBPractice/src/main/resources/response/ticketPriceResponse.json"),
                        TicketPriceResponse.class);
        return new ResponseEntity<>(ticketPriceResponse,HttpStatus.OK);

    }
}
