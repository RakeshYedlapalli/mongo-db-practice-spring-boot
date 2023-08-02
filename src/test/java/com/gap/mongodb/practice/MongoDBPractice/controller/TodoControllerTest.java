package com.gap.mongodb.practice.MongoDBPractice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gap.mongodb.practice.MongoDBPractice.model.ToDo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TodoControllerTest {
    @Test
    public void testCreateToDos() {
        TodoController todoController = new TodoController();

        ToDo toDo = new ToDo();
        toDo.setCompleted(true);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        toDo.setUpdateAt(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        toDo.setId("42");
        toDo.setDescription("The characteristics of someone or something");
        toDo.setTodo("Todo");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        toDo.setCredateAt(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        ResponseEntity<?> actualCreateToDosResult = todoController.createToDos(toDo,true);
        assertEquals("Data couldn't be persisted in db...", actualCreateToDosResult.getBody());
        assertEquals("<500 INTERNAL_SERVER_ERROR Internal Server Error,Data couldn't be persisted in db...,[]>",
                actualCreateToDosResult.toString());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualCreateToDosResult.getStatusCode());
        assertTrue(actualCreateToDosResult.getHeaders().isEmpty());
        assertEquals("This is default TO DO.", toDo.getTodo());
        Date expectedUpdateAt = toDo.getCredateAt();
        assertEquals(expectedUpdateAt, toDo.getUpdateAt());
    }

    @Test
    public void testDeleteTodoById() {
        ResponseEntity actualDeleteTodoByIdResult = (new TodoController()).deleteTodoById("42");
        assertEquals("Todo can't be deleted Internal server error", actualDeleteTodoByIdResult.getBody());
        assertEquals("<500 INTERNAL_SERVER_ERROR Internal Server Error,Todo can't be deleted Internal server error,[]>",
                actualDeleteTodoByIdResult.toString());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualDeleteTodoByIdResult.getStatusCode());
        assertTrue(actualDeleteTodoByIdResult.getHeaders().isEmpty());
    }
}

