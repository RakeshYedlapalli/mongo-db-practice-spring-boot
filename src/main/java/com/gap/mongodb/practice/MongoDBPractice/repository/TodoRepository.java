package com.gap.mongodb.practice.MongoDBPractice.repository;

import com.gap.mongodb.practice.MongoDBPractice.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<ToDo,String> {

    List<ToDo> findByTodo(String name);

}
