package com.gap.mongodb.practice.MongoDBPractice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todo")
public class ToDo {

    @Id
    private String id;
    private String todo;
    private String description;
    private boolean completed;
    private Date credateAt;
    private Date updateAt;
    private Double cost;

}
